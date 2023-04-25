package com.zufe.yt.order.domain.order.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.infrastructure.persistence.data.OrderDO;

/**
 * @author yt
 * @date 2023/4/24
 * @description: 订单持久化仓储接口
 */
public interface OrderRepository extends IRepository<Order, OrderDO> {
}
