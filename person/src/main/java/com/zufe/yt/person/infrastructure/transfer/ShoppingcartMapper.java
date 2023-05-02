package com.zufe.yt.person.infrastructure.transfer;

import com.zufe.yt.person.interfaces.dto.ShoppingcartInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import person.SeckillPersonRpc;
import product.SeckillProductRpc;

/**
 * @author yt
 * @date 2023/4/29
 * @description: TODO
 */
@Mapper
public interface ShoppingcartMapper {
    ShoppingcartMapper INSTANCE = Mappers.getMapper(ShoppingcartMapper.class);

    @Mapping(target = "price", source = "productSellingPrice")
    @Mapping(target = "productId", source = "id")
    ShoppingcartInfoDTO toDTO(SeckillProductRpc.ProductMessage.SimpleProduct simpleProduct);

    SeckillPersonRpc.ShoppingCartMessage.ShoppingCart toMessage(ShoppingcartInfoDTO shoppingcartInfoDTO);
}
