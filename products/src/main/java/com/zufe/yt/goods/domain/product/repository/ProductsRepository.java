package com.zufe.yt.goods.domain.product.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.infrastructure.persistence.data.ProductDO;
import com.zufe.yt.goods.interfaces.dto.CacheQueryDTO;

/**
 * @author yt
 * @date 2023/4/23
 * @description: 商品持久化服务接口
 */
public interface ProductsRepository extends IRepository<Product, ProductDO> {

    /**
     * 新增或修改
     *
     * @param product 入参
     * @return 主键
     */
    @Override
    String saveOrUpdate(Product product);

    /**
     * 删除
     *
     * @param queryDTO 对象
     */
    void delete(CacheQueryDTO queryDTO);

    /**
     * 根据ID获取奖品
     *
     * @param queryDTO  查询参数
     * @return 对象
     */
    Product findById(CacheQueryDTO queryDTO);
}
