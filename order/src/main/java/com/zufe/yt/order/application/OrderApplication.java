package com.zufe.yt.order.application;

import com.zufe.yt.order.domain.order.entity.Order;

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
}
