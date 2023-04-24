package com.zufe.yt.goods.application.service;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.util.MongoPage;
import com.zufe.yt.common.mongo.util.SortBuilder;
import com.zufe.yt.goods.application.ProductsApplication;
import com.zufe.yt.goods.domain.category.entity.Category;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.domain.product.repository.ProductsRepository;
import com.zufe.yt.goods.infrastructure.enums.CategoryEnum;
import com.zufe.yt.goods.infrastructure.persistence.data.ProductDO;
import com.zufe.yt.goods.infrastructure.transfer.CategoryMapper;
import com.zufe.yt.goods.infrastructure.util.EnumListUtil;
import com.zufe.yt.goods.interfaces.dto.CacheQueryDTO;
import com.zufe.yt.goods.interfaces.dto.QueryDTO;
import org.springframework.stereotype.Service;

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

    @Override
    public void saveOrUpdate(Product product) {
        product.valid();
        //id为空表示更新，校验一遍是否存在
        if (StrUtil.isBlank(product.getId())) {
            product.validExistence(productsRepository);
        }
        product.handleGlobalSearchValue();
        productsRepository.saveOrUpdate(product);
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
        if (!queryDTO.getCategoryId().isEmpty()) {
            wrapper.containOr(ProductDO::getCategoryId, queryDTO.getCategoryId());
        } else if (StrUtil.isNotBlank(queryDTO.getSearch())) {
            wrapper.like(ProductDO::getGlobalSearchValue, queryDTO.getSearch());
        }
        return productsRepository.page(
                new SortBuilder().desc(ProductDO::getCreateTime),
                new MongoPage<>(queryDTO.getCurrentPage(), queryDTO.getPageSize()),
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
}
