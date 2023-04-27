package com.zufe.yt.goods.application.service;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.util.MongoPage;
import com.zufe.yt.common.mongo.util.SortBuilder;
import com.zufe.yt.common.redis.util.LockUtil;
import com.zufe.yt.common.redis.util.RedisService;
import com.zufe.yt.goods.application.ProductsApplication;
import com.zufe.yt.goods.domain.category.Category;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.domain.product.repository.ProductsRepository;
import com.zufe.yt.goods.domain.stock.entity.Stock;
import com.zufe.yt.goods.domain.stock.repository.StockRepository;
import com.zufe.yt.goods.domain.stock.value.GotCount;
import com.zufe.yt.goods.domain.stock.value.ProductId;
import com.zufe.yt.goods.domain.stock.value.TotalCount;
import com.zufe.yt.goods.infrastructure.enums.CategoryEnum;
import com.zufe.yt.goods.infrastructure.enums.PageEnum;
import com.zufe.yt.goods.infrastructure.persistence.data.ProductDO;
import com.zufe.yt.goods.infrastructure.transfer.CategoryMapper;
import com.zufe.yt.goods.infrastructure.util.EnumListUtil;
import com.zufe.yt.goods.interfaces.dto.CacheQueryDTO;
import com.zufe.yt.goods.interfaces.dto.QueryDTO;
import com.zufe.yt.goods.interfaces.dto.StockDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.goods.application.service
 * @className: ProductsApplicationImpl
 * @date 2023/4/23
 * @description: 商品服务应用层实现类
 */

@Service
public class ProductsApplicationImpl implements ProductsApplication {

    @Resource
    ProductsRepository productsRepository;
    @Resource
    StockRepository stockRepository;
    @Resource
    private RedisService redisService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static final String UNIQUE = "UUID:%S";
    private static final String SYNC_STOCK_KEY = "SYNC:STOCK";
    private static final Long TIME = 3600L;

    /**
     * 初始化 开启一个定时器 定时刷新被修改的库存同步到数据库
     */
    @PostConstruct
    public void init() {
        ThreadUtil.execAsync(() -> {
            while (true) {
                Object data = redisTemplate.opsForSet().pop(SYNC_STOCK_KEY);
                if (data == null) {
                    ThreadUtil.sleep(1000);
                    continue;
                }
                //productId
                String value = data.toString();

                LockUtil.lock("SYNC:STOCK:LOCK:" + value, 500, () -> {
                    Stock stock = stockRepository.findById(value);
                    if (stock != null) {
                        stockRepository.save(stock);
                    }
                });
            }
        }, true);
    }

    @Override
    public void saveOrUpdate(Product product) {
        product.valid();
        boolean createFlag = false;
        //id不为空表示更新
        if (StrUtil.isNotBlank(product.getId())) {
            Stock find = stockRepository.findById(product.getId());
            if (find == null) {
                throw new ServiceException("库存不存在", 200001);
            }
            //只更新总的数量，其他的不更新
            stockRepository.setTotalCount(product.getId(), product.getProductNum());
            //更新数据库
            find.setTotalCount(new TotalCount(product.getProductNum()));
            stockRepository.save(find);
        } else {
            product.validExistence(productsRepository);
            createFlag = true;
        }
        product.handleGlobalSearchValue();
        String id = productsRepository.saveOrUpdate(product);
        if (createFlag) {
            //新增一个库存
            Stock stock = Stock.builder()
                    .productId(new ProductId(id))
                    .totalCount(new TotalCount(product.getProductNum()))
                    .gotCount(new GotCount(0))
                    .build();
            stockRepository.save(stock);
        }
    }

    @Override
    public void delete(CacheQueryDTO queryDTO) {
        if (StrUtil.isBlank(queryDTO.getId()) || null == queryDTO.getCategoryId()) {
            throw new ServiceException("参数有误", 100001);
        }
        productsRepository.delete(queryDTO);
    }

    @Override
    public List<Category> getCategory() {
        return CategoryMapper.INSTANCE.toEntityList(EnumListUtil.enumToListMap(CategoryEnum.class));
    }

    @Override
    public MongoPage<Product> getProductList(QueryDTO queryDTO) {
        CriteriaAndWrapper wrapper = new CriteriaAndWrapper();
        if (StrUtil.isNotBlank(queryDTO.getSearch())) {
            wrapper.like(ProductDO::getGlobalSearchValue, queryDTO.getSearch());
        } else if (!queryDTO.getCategoryId().isEmpty()) {
            wrapper.containOr(ProductDO::getCategoryId, queryDTO.getCategoryId());

        }
        //todo:返回库存
        return productsRepository.page(
                new SortBuilder().desc(ProductDO::getCreateTime),
                new MongoPage<>(queryDTO.getCurrentPage() == 0 ? PageEnum.CURRENT_PAGE.getNum() : queryDTO.getCurrentPage(),
                        queryDTO.getPageSize() == 0 ? PageEnum.PAGE_SIZE.getNum() : queryDTO.getPageSize()),
                wrapper
        );
    }

    @Override
    public Product getProductDetail(CacheQueryDTO queryDTO) {
        if (StrUtil.isBlank(queryDTO.getId()) || null == queryDTO.getCategoryId()) {
            throw new ServiceException("参数有误", 100001);
        }
        Product product = productsRepository.findById(queryDTO);
        if (null == product) {
            throw new ServiceException("商品不存在", 100001);
        }
        return product;
    }

    @Override
    public String incCount(StockDTO stockDTO) {
        if (stockDTO.getIncCount() == null || stockDTO.getIncCount() <= 0) {
            throw new ServiceException("操作数异常", 100001);
        }
        //先判断幂等
        if (StringUtils.isNotBlank(stockDTO.getUuid())) {
            String key = String.format(UNIQUE, stockDTO.getUuid());
            if (redisService.hasKey(key)) {
                return "";
            }
            redisService.set(key, "", TIME);
        }
        //todo:考虑一下怎么在缓存里查，现在的缓存需要categoryId，后续优化
        Product product = productsRepository.findById(stockDTO.getProductId());
        if (product == null) {
            throw new ServiceException("商品不存在", 100001);
        }
        //走lua脚本获取
        Stock stock = stockRepository.findById(stockDTO.getProductId());
        if (stock == null) {
            throw new ServiceException("库存不存在", 100001);
        }
        //走lua扣除
        Long res = stockRepository.incGotCount(stockDTO.getIncCount(), stock);
        if (res == null || res <= 0) {
            throw new ServiceException("库存不足", 100003);
        }
        redisService.sSet(SYNC_STOCK_KEY, stockDTO.getProductId());
        //todo:生成codeId返回，这里先简单用uuid代替一下
        return UUID.fastUUID().toString();
    }
}
