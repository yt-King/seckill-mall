package com.zufe.yt.order.application;

import com.zufe.yt.order.domain.order.entity.Order;

import java.util.List;

/**
 * @author yt
 * @date 2023/4/24
 * @description: 订单应用层接口
 */
public interface OrderApplication {
    /**
     * 新增订单
     * @param order 订单实体
     */
    void addOrder(Order order);
    /**
     * 获取订单
     * @param userId 用户id
     * @return List<Order> 用户订单
     */
    List<Order> getOrder(String userId);
}
