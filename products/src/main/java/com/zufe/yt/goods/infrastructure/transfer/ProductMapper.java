package com.zufe.yt.goods.infrastructure.transfer;

import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.interfaces.dto.QueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import product.SeckillProductRpc;


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
     * rpc查询转dto
     *
     * @param getAllProductReq 入参
     * @return QueryDTO dto
     */
    QueryDTO toQuery(SeckillProductRpc.ProductMessage.GetAllProductsReq getAllProductReq);

    /**
     * 实体转message
     *
     * @param product 入参
     * @return Product dto
     */
    SeckillProductRpc.ProductMessage.Product toMessage(Product product);
}
