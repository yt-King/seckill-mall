package com.zufe.yt.order.infrastructure.persistence.repository;

import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.domain.order.repository.OrderRepository;
import com.zufe.yt.order.infrastructure.persistence.data.OrderDO;

/**
 * @author yt
 * @package: com.zufe.yt.order.infrastructure.persistence.repository
 * @className: OrderRepositoryImpl
 * @date 2023/4/24
 * @description: 订单持久化仓储实现类
 */
public class OrderRepositoryImpl extends RepositoryImpl<Order, OrderDO> implements OrderRepository {
}
