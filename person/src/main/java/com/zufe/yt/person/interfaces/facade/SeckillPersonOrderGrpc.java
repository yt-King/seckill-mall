package com.zufe.yt.person.interfaces.facade;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import person.SeckillPersonOrderServiceGrpc;
import person.SeckillPersonRpc;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.facade
 * @className: SeckillPersonOrderGrpc
 * @date 2023/4/25
 * @description: TODO
 */

@GrpcService
public class SeckillPersonOrderGrpc extends SeckillPersonOrderServiceGrpc.SeckillPersonOrderServiceImplBase {
    @Override
    public void getOrder(SeckillPersonRpc.PersonOrderMessage.GetOrderReq request, StreamObserver<SeckillPersonRpc.PersonOrderMessage.GetOrderRely> responseObserver) {
        super.getOrder(request, responseObserver);
    }
}
