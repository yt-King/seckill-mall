package com.zufe.yt.order.domain.order.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.infrastructure.persistence.data.OrderDO;

import java.util.List;

/**
 * @author yt
 * @date 2023/4/24
 * @description: 订单持久化仓储接口
 */
public interface OrderRepository extends IRepository<Order, OrderDO> {
    /**
     * 新增或修改
     *
     * @param order 入参
     * @return 主键
     */
    @Override
    String saveOrUpdate(Order order);

    /**
     * 获取用户订单
     *
     * @param userId 入参
     * @return 列表
     */
    List<Order> getOrder(String userId);
}
