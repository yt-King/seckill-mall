package com.zufe.yt.order.infrastructure.transfer;

import com.zufe.yt.order.domain.order.entity.ChildOrder;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.infrastructure.persistence.data.ChildOrderDO;
import com.zufe.yt.order.infrastructure.persistence.data.OrderDO;
import order.SeckillOrderRpc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
    @Mapping(target = "productId.value", source = "productId")
    @Mapping(target = "price.value", source = "price")
    @Mapping(target = "num.value", source = "num")
    ChildOrder toEntity(SeckillOrderRpc.OrderMessage.ChildOrder childOrder);

    /**
     * 持久化对象转实体
     *
     * @param childOrderDO 入参
     * @return ChildOrder 实体
     */
    @Mapping(target = "productId.value", source = "productId")
    @Mapping(target = "price.value", source = "price")
    @Mapping(target = "num.value", source = "num")
    ChildOrder toEntity(ChildOrderDO childOrderDO);

    /**
     * 实体转持久化对象
     *
     * @param childOrder 入参
     * @return ChildOrderDO 持久化对象
     */
    @Mapping(source = "productId.value", target = "productId")
    @Mapping(source = "price.value", target = "price")
    @Mapping(source = "num.value", target = "num")
    ChildOrderDO toDO(ChildOrder childOrder);

    /**
     * rpc新增入参转实体
     *
     * @param addOrderReq 入参
     * @return Order 实体
     */
    @Mapping(source = "ordersList", target = "childOrders")
    Order toEntity(SeckillOrderRpc.OrderMessage.AddOrderReq addOrderReq);

    /**
     * 持久化对象转实体
     *
     * @param orderDO 入参
     * @return Order 实体
     */
    Order toEntity(OrderDO orderDO);

    /**
     * 持久化对象转实体
     *
     * @param orderDOList 入参
     * @return List<Order> 实体
     */
    List<Order> toEntityList(List<OrderDO> orderDOList);

    /**
     * 实体转持久化对象
     *
     * @param order 入参
     * @return OrderDO 持久化对象
     */
    OrderDO toDO(Order order);

    /**
     * 实体转rpc消息
     *
     * @param childOrder 入参
     * @return SeckillOrderRpc.OrderMessage.ChildOrder rpc消息
     */
    @Mapping(source = "productId.value", target = "productId")
    @Mapping(source = "price.value", target = "price")
    @Mapping(source = "num.value", target = "num")
    SeckillOrderRpc.OrderMessage.ChildOrder toMessage(ChildOrder childOrder);

    /**
     * 实体转rpc消息列表
     *
     * @param childOrder 入参
     * @return List SeckillOrderRpc.OrderMessage.ChildOrder rpc消息
     */
    List<SeckillOrderRpc.OrderMessage.ChildOrder> toMessageList(List<ChildOrder> childOrder);

    /**
     * 实体转rpc消息
     *
     * @param order 入参
     * @return SeckillOrderRpc.OrderMessage.AddOrderReq rpc消息
     */
    @Mapping(target = "childOrdersList", source = "childOrders")
    SeckillOrderRpc.OrderMessage.Order toMessage(Order order);
}
