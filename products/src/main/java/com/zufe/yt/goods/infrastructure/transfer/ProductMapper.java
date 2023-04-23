package com.zufe.yt.goods.infrastructure.transfer;

import com.zufe.yt.goods.domain.category.entity.Category;
import com.zufe.yt.goods.domain.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import product.SeckillProductRpc;

import java.util.List;
import java.util.Map;


/**
 * @author yt
 * @date 2023/4/23
 * @description: TODO
 */

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    /**
     * rpc新增入参转实体
     *
     * @param saveOrUpdateProductReq 入参
     * @return Product 实体
     */
    Product toEntity(SeckillProductRpc.ProductMessage.SaveOrUpdateProductReq saveOrUpdateProductReq);

    /**
     * rpc新增入参转实体
     *
     * @param list 入参
     * @return Product 实体
     */
    List<Category> toEntity(List<Map<String, Object>> list);
}
