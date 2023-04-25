package com.zufe.yt.order.infrastructure.transfer;

import com.zufe.yt.order.domain.order.entity.Order;
import order.SeckillOrderRpc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author yt
 * @date 2023/4/24
 * @description: 订单转换类
 */

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /**
     * rpc新增入参转实体
     *
     * @param addOrderReq 入参
     * @return Order 实体
     */
    @Mapping(target = "price.value", source = "productName")
    Order toEntity(SeckillOrderRpc.OrderMessage.AddOrderReq addOrderReq);
}
