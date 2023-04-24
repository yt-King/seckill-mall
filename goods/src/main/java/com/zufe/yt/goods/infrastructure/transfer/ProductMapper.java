package com.zufe.yt.goods.infrastructure.transfer;

import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.infrastructure.persistence.data.ProductDO;
import com.zufe.yt.goods.interfaces.dto.CacheQueryDTO;
import com.zufe.yt.goods.interfaces.dto.QueryDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import product.SeckillProductRpc;

import java.util.List;


/**
 * @author yt
 * @date 2023/4/23
 * @description: TODO
 */

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    /**
     * 实体转持久化对象
     *
     * @param product 入参
     * @return ProductDO 持久化对象
     */
    @Mapping(source = "productName.value", target = "productName")
    @Mapping(source = "productPrice.value", target = "productPrice")
    @Mapping(source = "productSellingPrice.value", target = "productSellingPrice")
    ProductDO toDO(Product product);

    /**
     * rpc新增入参转实体
     *
     * @param saveOrUpdateProductReq 入参
     * @return Product 实体
     */
    @Mapping(target = "productName.value", source = "productName")
    @Mapping(target = "productPrice.value", source = "productPrice")
    @Mapping(target = "productSellingPrice.value", source = "productSellingPrice")
    Product toEntity(SeckillProductRpc.ProductMessage.SaveOrUpdateProductReq saveOrUpdateProductReq);

    /**
     * 持久化对象转领域对象
     *
     * @param productDO 入参
     * @return Product 实体
     */
    @InheritInverseConfiguration
    Product toEntity(ProductDO productDO);

    /**
     * 持久化对象列表转领域对象列表
     *
     * @param productDOList 入参
     * @return Product 实体
     */
    List<Product> toEntityList(List<ProductDO> productDOList);

    /**
     * rpc查询转dto
     *
     * @param getAllProductReq 入参
     * @return QueryDTO dto
     */
    @Mapping(source = "categoryIdList", target = "categoryId")
    QueryDTO toQuery(SeckillProductRpc.ProductMessage.GetAllProductsReq getAllProductReq);

    /**
     * rpc查询转dto
     *
     * @param getProductDetailReq 入参
     * @return QueryDTO dto
     */
    CacheQueryDTO toCacheQuery(SeckillProductRpc.ProductMessage.GetProductDetailReq getProductDetailReq);

    /**
     * rpc删除条件转dto
     *
     * @param deleteProductReq 入参
     * @return QueryDTO dto
     */
    CacheQueryDTO toCacheQuery(SeckillProductRpc.ProductMessage.DeleteProductReq deleteProductReq);

    /**
     * 实体转message
     *
     * @param product 入参
     * @return Product dto
     */
    @Mapping(source = "productName.value", target = "productName")
    @Mapping(source = "productPrice.value", target = "productPrice")
    @Mapping(source = "productSellingPrice.value", target = "productSellingPrice")
    SeckillProductRpc.ProductMessage.SimpleProduct toSimpleMessage(Product product);

    /**
     * 实体转message
     *
     * @param product 入参
     * @return Product dto
     */
    @Mapping(source = "productName.value", target = "productName")
    @Mapping(source = "productPrice.value", target = "productPrice")
    @Mapping(source = "productSellingPrice.value", target = "productSellingPrice")
    SeckillProductRpc.ProductMessage.Product toMessage(Product product);
}
