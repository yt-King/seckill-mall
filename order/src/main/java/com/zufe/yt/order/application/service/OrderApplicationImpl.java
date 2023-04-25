package com.zufe.yt.order.application.service;

import com.zufe.yt.order.application.OrderApplication;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.domain.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yt
 * @package: com.zufe.yt.order.application.service
 * @className: OrderApplicationImpl
 * @date 2023/4/24
 * @description: 订单应用层实现类
 */

@Service
public class OrderApplicationImpl implements OrderApplication {
    @Resource
    OrderRepository orderRepository;

    @Override
    public void addOrder(Order order) {
        orderRepository.saveOrUpdate(order);
    }
}
