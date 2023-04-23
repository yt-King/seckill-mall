package com.zufe.yt.goods.application;

import com.zufe.yt.goods.domain.category.entity.Category;
import com.zufe.yt.goods.domain.product.entity.Product;

import java.util.List;

/**
 * @author yt
 * @date 2023/4/23
 * @description: TODO
 */
public interface ProductsApplication {
    /**
     * 新增
     */
    void saveOrUpdate(Product product);

    /**
     * 删除
     */
    void delete(String id);

    /**
     * 获取类目列表
     */
    List<Category> getCategory();
}
