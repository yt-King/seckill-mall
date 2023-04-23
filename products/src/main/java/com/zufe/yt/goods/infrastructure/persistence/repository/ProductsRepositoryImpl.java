package com.zufe.yt.goods.infrastructure.persistence.repository;

import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.domain.product.repository.ProductsRepository;
import com.zufe.yt.goods.infrastructure.persistence.data.ProductDO;
import org.springframework.stereotype.Repository;

/**
 * @author yt
 * @package: com.zufe.yt.goods.infrastructure.persistence.repository
 * @className: ProductsRepositoryImlp
 * @date 2023/4/23
 * @description: 商品持久化服务实现类
 */

@Repository
public class ProductsRepositoryImpl extends RepositoryImpl<Product, ProductDO> implements ProductsRepository {
}
