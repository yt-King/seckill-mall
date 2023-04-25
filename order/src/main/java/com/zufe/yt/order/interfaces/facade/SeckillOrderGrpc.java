package com.zufe.yt.order.interfaces.facade;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import order.SeckillOrderRpc;
import order.SeckillOrderServiceGrpc;

/**
 * @author yt
 * @package: com.zufe.yt.order.interfaces.facade
 * @className: SeckillOrderGrpc
 * @date 2023/4/24
 * @description: 订单接口层,只做写订单用，因为压力最大，查询订单放到用户领域去做
 */

@GrpcService
public class SeckillOrderGrpc extends SeckillOrderServiceGrpc.SeckillOrderServiceImplBase {
    @Override
    public void addOrder(SeckillOrderRpc.OrderMessage.AddOrderReq request, StreamObserver<SeckillOrderRpc.OrderMessage.CommonRely> responseObserver) {
        super.addOrder(request, responseObserver);
    }
}
