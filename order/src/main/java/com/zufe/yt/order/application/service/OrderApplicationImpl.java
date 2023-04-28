package com.zufe.yt.order.application.service;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.order.application.OrderApplication;
import com.zufe.yt.order.domain.order.entity.ChildOrder;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.domain.order.repository.OrderRepository;
import com.zufe.yt.order.infrastructure.enums.OrderStatusEnum;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import product.SeckillProductRpc;
import product.SeckillProductServiceGrpc;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.order.application.service
 * @className: OrderApplicationImpl
 * @date 2023/4/24
 * @description: 订单应用层实现类
 */

@Service
@Slf4j
public class OrderApplicationImpl implements OrderApplication {
    @Resource
    OrderRepository orderRepository;
    @GrpcClient("products")
    SeckillProductServiceGrpc.SeckillProductServiceBlockingStub productsStub;

    @Override
    public void addOrder(Order order) {
        order.valid();
        //依次扣库存生成订单，成功的订单返回唯一的codeId，幂等返回空字符串，失败报错
        for (ChildOrder childOrder : order.getChildOrders()) {
            try {
                String codeId = productsStub.incGotCount(SeckillProductRpc.ProductMessage.IncGotCountReq.newBuilder()
                        .setProductId(childOrder.getProductId().getValue())
                        .setIncCount(childOrder.getNum().getValue())
                        //下游接口幂等时间30s，这30s里面参数一样的就算是幂等了
                        .setUuid(order.getUserId() + childOrder.getProductId().getValue() + childOrder.getNum().getValue())
                        .build()).getCodeId();
                if (StrUtil.isBlank(codeId)) {
                    //如果为空表示幂等了
                    throw new ServiceException("请勿重复下单", 100005);
                }
                //正常情况下返回全局唯一的codeId，当作子订单的id
                childOrder.setId(codeId);
                childOrder.setStatus(OrderStatusEnum.SUCCESS.name());
            } catch (StatusRuntimeException e) {
                assert e.getStatus().getDescription() != null;
                //如果是库存不足则写库存不足，其他异常写购买失败
                if (Integer.parseInt(e.getStatus().getDescription().split(":")[0]) == ResultCode.STOCK_INSUFFICIENT.getCode()) {
                    childOrder.setStatus(OrderStatusEnum.STOCK_INSUFFICIENT.name());
                } else {
                    childOrder.setStatus(OrderStatusEnum.OTHER_FAILURE.name());
                }
            } catch (Exception e) {
                //未知异常，打印一下
                log.error("make codeId error:{}", e.getMessage());
                childOrder.setStatus(OrderStatusEnum.UNKNOWN.name());
            }
        }
        orderRepository.saveOrUpdate(order);
    }

    @Override
    public List<Order> getOrder(String userId) {
        return orderRepository.getOrder(userId);
    }
}
