package com.zufe.yt.order.infrastructure.persistence.repository;

import com.alibaba.fastjson.JSON;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.common.redis.util.CacheUtil;
import com.zufe.yt.common.redis.util.RedisService;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.domain.order.repository.OrderRepository;
import com.zufe.yt.order.infrastructure.persistence.data.OrderDO;
import com.zufe.yt.order.infrastructure.transfer.OrderMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.order.infrastructure.persistence.repository
 * @className: OrderRepositoryImpl
 * @date 2023/4/24
 * @description: 订单持久化仓储实现类
 */

@Repository
public class OrderRepositoryImpl extends RepositoryImpl<Order, OrderDO> implements OrderRepository {
    @Resource
    private RedisService redisService;
    private final String REDIS_KEY = "CACHE_ORDER_KEY:%s";

    @Override
    public String saveOrUpdate(Order order) {
        OrderDO orderDO = OrderMapper.INSTANCE.toDO(order);
        String id = mongoUtil.insertOrUpdate(orderDO);
        orderDO.setId(id);

        String key = String.format(REDIS_KEY, orderDO.getUserId());
        List<OrderDO> list = this.getRedisList(key, orderDO.getUserId());

        list.removeIf(x -> orderDO.getId().equals(x.getId()));
        list.add(orderDO);
        redisService.set(key, JSON.toJSONString(list), 1200L);

        return id;
    }

    @Override
    public List<Order> getOrder(String userId) {
        String key = String.format(REDIS_KEY, userId);
        this.checkRedis(key, userId);
        Object value = redisService.get(key);
        return OrderMapper.INSTANCE.toEntityList(JSON.parseArray(value.toString(), OrderDO.class));
    }

    private List<OrderDO> getRedisList(String key, String userId) {
        this.checkRedis(key, userId);

        Object value = redisService.get(key);

        return JSON.parseArray(value.toString(), entityClass);
    }

    private void checkRedis(String key, String userId) {
        CacheUtil.renewOrSet(key, 1200, () -> mongoUtil.findListByQuery(
                new CriteriaAndWrapper().eq(OrderDO::getUserId, userId), entityClass), false);
    }
}
