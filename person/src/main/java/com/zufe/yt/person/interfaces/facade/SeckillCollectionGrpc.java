package com.zufe.yt.person.interfaces.facade;

import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.common.redis.util.LockUtil;
import com.zufe.yt.person.application.CollectionApplication;
import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.infrastructure.transfer.CollectionMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import person.SeckillCollectionServiceGrpc;
import person.SeckillPersonRpc;

import javax.annotation.Resource;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.facade
 * @className: SeckillCollectionGrpc
 * @date 2023/4/25
 * @description: 接口层
 */
@GrpcService
public class SeckillCollectionGrpc extends SeckillCollectionServiceGrpc.SeckillCollectionServiceImplBase {
    @Resource
    private CollectionApplication collectionApplication;
    private final String lockKey = "PERSON-";

    @Override
    public void addCollect(SeckillPersonRpc.CollectionMessage.AddCollectionReq request, StreamObserver<SeckillPersonRpc.CollectionMessage.CommonRely> responseObserver) {
        SeckillPersonRpc.CollectionMessage.CommonRely.Builder builder = SeckillPersonRpc.CollectionMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "ADD-" + request.getUserId(), 500, () -> {
            Collection collection = CollectionMapper.INSTANCE.toEntity(request);
            collectionApplication.save(collection);
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCollect(SeckillPersonRpc.CollectionMessage.DeleteCollectReq request, StreamObserver<SeckillPersonRpc.CollectionMessage.CommonRely> responseObserver) {
        SeckillPersonRpc.CollectionMessage.CommonRely.Builder builder = SeckillPersonRpc.CollectionMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "DELETE-" + request.getUserId(), 500, () -> {
            Collection collection = CollectionMapper.INSTANCE.toEntity(request);
            collectionApplication.delete(collection);
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCollect(SeckillPersonRpc.CollectionMessage.GetCollectReq request, StreamObserver<SeckillPersonRpc.CollectionMessage.GetCollectRely> responseObserver) {
        SeckillPersonRpc.CollectionMessage.GetCollectRely.Builder builder = SeckillPersonRpc.CollectionMessage.GetCollectRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        collectionApplication.getCollection(request.getUserId());
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
