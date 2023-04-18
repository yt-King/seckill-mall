package com.zufe.yt.person.interfaces.facade;

import com.zufe.yt.common.core.constant.ResultCode;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import person.SeckillPersonRpc;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.facade
 * @className: SeckillPersonGrpc
 * @date 2023/4/18
 * @description: TODO
 */
@GrpcService
public class SeckillPersonGrpc extends person.SeckillPersonServiceGrpc.SeckillPersonServiceImplBase {
    @Override
    public void create(SeckillPersonRpc.PersonMessage.CreatePersonReq request, StreamObserver<SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
        SeckillPersonRpc.PersonMessage.CommonRely.Builder builder = SeckillPersonRpc.PersonMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
//        JSONObject object = ProtoBeanUtil.toBean(request, JSONObject.class);
//        String id = taskApplication.create(task);
//        builder.setTaskId(id);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

}
