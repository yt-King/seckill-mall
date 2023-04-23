package com.zufe.yt.goods.domain.product.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.infrastructure.persistence.data.ProductDO;

/**
 * @author yt
 * @date 2023/4/23
 * @description: 商品持久化服务接口
 */
public interface ProductsRepository extends IRepository<Product, ProductDO> {
}
