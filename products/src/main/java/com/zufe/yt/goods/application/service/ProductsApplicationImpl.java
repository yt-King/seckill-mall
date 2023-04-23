package com.zufe.yt.goods.application.service;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.goods.application.ProductsApplication;
import com.zufe.yt.goods.domain.category.entity.Category;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.domain.product.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.goods.application.service
 * @className: ProductsApplicationImpl
 * @date 2023/4/23
 * @description: TODO
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
        productsRepository.saveOrUpdate(product);
    }

    @Override
    public void delete(String id) {
        productsRepository.removeById(id);
    }

    @Override
    public List<Category> getCategory() {
//        return EnumListUtil.enumToListMap(Category.class);
        return null;
    }
}