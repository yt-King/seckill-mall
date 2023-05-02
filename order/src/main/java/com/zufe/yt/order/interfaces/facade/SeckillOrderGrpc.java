package com.zufe.yt.order.interfaces.facade;

import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.order.application.OrderApplication;
import com.zufe.yt.order.domain.order.entity.ChildOrder;
import com.zufe.yt.order.domain.order.entity.Order;
import com.zufe.yt.order.infrastructure.transfer.OrderMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import order.SeckillOrderRpc;
import order.SeckillOrderServiceGrpc;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.order.interfaces.facade
 * @className: SeckillOrderGrpc
 * @date 2023/4/24
 * @description: 订单接口层
 */

@GrpcService
public class SeckillOrderGrpc extends SeckillOrderServiceGrpc.SeckillOrderServiceImplBase {
    @Resource
    OrderApplication orderApplication;

    @Override
    public void addOrder(SeckillOrderRpc.OrderMessage.AddOrderReq request, StreamObserver<SeckillOrderRpc.OrderMessage.CommonRely> responseObserver) {
        SeckillOrderRpc.OrderMessage.CommonRely.Builder builder = SeckillOrderRpc.OrderMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        Order order = OrderMapper.INSTANCE.toEntity(request);
        orderApplication.addOrder(order);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getOrder(SeckillOrderRpc.OrderMessage.GetOrderReq request, StreamObserver<SeckillOrderRpc.OrderMessage.GetOrderRely> responseObserver) {
        SeckillOrderRpc.OrderMessage.GetOrderRely.Builder builder = SeckillOrderRpc.OrderMessage.GetOrderRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        List<Order> orderList = orderApplication.getOrder(request.getUserId());
        Collections.reverse(orderList);
        for (Order order : orderList) {
            SeckillOrderRpc.OrderMessage.Order.Builder orderBuilder = SeckillOrderRpc.OrderMessage.Order.newBuilder();
            orderBuilder.setId(order.getId());
            orderBuilder.setCreateTime(order.getCreateTime());
            for (ChildOrder childOrder : order.getChildOrders()) {
                orderBuilder.addChildOrders(OrderMapper.INSTANCE.toMessage(childOrder));
            }
            builder.addOrders(orderBuilder.build());
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}