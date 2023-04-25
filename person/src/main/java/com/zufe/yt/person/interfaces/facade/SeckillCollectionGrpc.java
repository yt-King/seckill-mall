package com.zufe.yt.person.interfaces.facade;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import person.SeckillCollectionServiceGrpc;
import person.SeckillPersonRpc;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.facade
 * @className: SeckillCollectionGrpc
 * @date 2023/4/25
 * @description: 接口层
 */
@GrpcService
public class SeckillCollectionGrpc extends SeckillCollectionServiceGrpc.SeckillCollectionServiceImplBase {
    @Override
    public void addCollect(SeckillPersonRpc.CollectionMessage.AddCollectionReq request, StreamObserver<SeckillPersonRpc.CollectionMessage.CommonRely> responseObserver) {
        super.addCollect(request, responseObserver);
    }

    @Override
    public void deleteCollect(SeckillPersonRpc.CollectionMessage.DeleteCollectReq request, StreamObserver<SeckillPersonRpc.CollectionMessage.CommonRely> responseObserver) {
        super.deleteCollect(request, responseObserver);
    }

    @Override
    public void getCollect(SeckillPersonRpc.CollectionMessage.GetCollectReq request, StreamObserver<SeckillPersonRpc.CollectionMessage.GetCollectRely> responseObserver) {
        super.getCollect(request, responseObserver);
    }
}
