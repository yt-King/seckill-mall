package com.zufe.yt.goods.infrastructure.persistence.repository;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Lists;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.common.redis.util.CacheUtil;
import com.zufe.yt.common.redis.util.RedisService;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.domain.product.repository.ProductsRepository;
import com.zufe.yt.goods.infrastructure.persistence.data.ProductDO;
import com.zufe.yt.goods.infrastructure.transfer.ProductMapper;
import com.zufe.yt.goods.interfaces.dto.CacheQueryDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author yt
 * @package: com.zufe.yt.goods.infrastructure.persistence.repository
 * @className: ProductsRepositoryImlp
 * @date 2023/4/23
 * @description: 商品持久化服务实现类
 */

@Repository
public class ProductsRepositoryImpl extends RepositoryImpl<Product, ProductDO> implements ProductsRepository {
    @Resource
    private RedisService redisService;

    private final Cache<String, List<Product>> cache = Caffeine.newBuilder().initialCapacity(50).maximumSize(1000)
            .expireAfterWrite(5, TimeUnit.SECONDS).build();

    private final String CACHE_KEY = "CACHE_PRODUCT_KEY:%s";

    private final String REDIS_KEY = "CACHE_PRODUCT_KEY:%s";

    @Override
    public String saveOrUpdate(Product product) {
        //找出原来的数据，如果categoryId变动的话要在原来的redis组里去掉这个
        Product old = super.findById(product.getId());
        ProductDO productDO = ProductMapper.INSTANCE.toDO(product);
        String id = mongoUtil.insertOrUpdate(productDO);
        product.setId(id);

        if (!Objects.equals(old.getCategoryId(), product.getCategoryId())) {
            List<ProductDO> list = this.getRedisList(String.format(REDIS_KEY, old.getCategoryId()), old.getCategoryId());
            list.removeIf(x -> product.getId().equals(x.getId()));
            redisService.set(String.format(REDIS_KEY, old.getCategoryId()), JSON.toJSONString(list), 1200L);
        }

        String key = String.format(REDIS_KEY, product.getCategoryId());
        List<ProductDO> list = this.getRedisList(key, product.getCategoryId());
        list.removeIf(x -> product.getId().equals(x.getId()));
        list.add(productDO);
        redisService.set(key, JSON.toJSONString(list), 1200L);

        cache.put(String.format(CACHE_KEY, productDO.getCategoryId()), ProductMapper.INSTANCE.toEntityList(list));

        return id;
    }

    @Override
    public void delete(CacheQueryDTO queryDTO) {
        this.removeById(queryDTO.getId());
        String key = String.format(REDIS_KEY, queryDTO.getCategoryId());
        List<ProductDO> list = this.getRedisList(key, queryDTO.getCategoryId());
        list.removeIf(x -> x.getId().equals(queryDTO.getId()));

        redisService.set(key, JSON.toJSONString(list), 1200L);

        cache.put(String.format(CACHE_KEY, queryDTO.getCategoryId()), ProductMapper.INSTANCE.toEntityList(list));
    }

    @Override
    public Product findById(CacheQueryDTO queryDTO) {
        List<Product> products = this.getCacheList(queryDTO.getCategoryId());

        return products.stream().filter(x -> x.getId().equals(queryDTO.getId())).findAny().orElse(null);
    }

    private List<ProductDO> getRedisList(String key, Integer categoryId) {
        this.checkRedis(key, categoryId);

        Object value = redisService.get(key);

        return JSON.parseArray(value.toString(), entityClass);
    }

    private void checkRedis(String key, Integer categoryId) {
        CacheUtil.renewOrSet(key, 1200, () -> mongoUtil.findListByQuery(
                new CriteriaAndWrapper().eq(ProductDO::getCategoryId, categoryId), entityClass), false);
    }

    private List<Product> getCacheList(Integer categoryId) {
        return cache.get(String.format(CACHE_KEY, categoryId), f -> {
            String key = String.format(REDIS_KEY, categoryId);
            List<ProductDO> productDOList = this.getRedisList(key, categoryId);
            if (CollUtil.isEmpty(productDOList)) {
                return Lists.newArrayList();
            }
            return ProductMapper.INSTANCE.toEntityList(productDOList);
        });
    }
}
