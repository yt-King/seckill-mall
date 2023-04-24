package com.zufe.yt.goods.application;

import com.zufe.yt.common.mongo.util.MongoPage;
import com.zufe.yt.goods.domain.category.entity.Category;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.interfaces.dto.CacheQueryDTO;
import com.zufe.yt.goods.interfaces.dto.QueryDTO;

import java.util.List;

/**
 * @author yt
 * @date 2023/4/23
 * @description: 商品服务应用层接口
 */
public interface ProductsApplication {
    /**
     * 新增
     */
    void saveOrUpdate(Product product);

    /**
     * 删除
     */
    void delete(CacheQueryDTO queryDTO);

    /**
     * 获取类目列表
     */
    List<Category> getCategory();

    /**
     * 获取商品列表
     */
    MongoPage<Product> getProductList(QueryDTO queryDTO);

    /**
     * 获取商品详情
     */
    Product getProductDetail(CacheQueryDTO queryDTO);
}
