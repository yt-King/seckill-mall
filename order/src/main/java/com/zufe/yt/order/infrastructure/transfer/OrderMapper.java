package com.zufe.yt.order.infrastructure.transfer;

import com.zufe.yt.order.domain.order.entity.ChildOrder;
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
     * @param childOrder 入参
     * @return ChildOrder 实体
     */
    @Mapping(target = "price.value", source = "price")
    @Mapping(target = "num.value", source = "num")
    ChildOrder toEntity(SeckillOrderRpc.OrderMessage.ChildOrder childOrder);

//    /**
//     * rpc新增入参转实体
//     *
//     * @param order 入参
//     * @return List<ChildOrder> 实体列表
//     */
//    List<ChildOrder> toEntity(SeckillOrderRpc.OrderMessage.Order order);

    /**
     * rpc新增入参转实体
     *
     * @param addOrderReq 入参
     * @return Order 实体
     */
    @Mapping(source = "ordersList", target = "childOrders")
    Order toEntity(SeckillOrderRpc.OrderMessage.AddOrderReq addOrderReq);
}
