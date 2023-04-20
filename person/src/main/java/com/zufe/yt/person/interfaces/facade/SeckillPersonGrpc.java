package com.zufe.yt.person.interfaces.facade;

import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.common.redis.util.LockUtil;
import com.zufe.yt.person.application.PersonApplication;
import com.zufe.yt.person.domain.person.entity.Person;
import com.zufe.yt.person.infrastructure.transfer.PersonMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import person.SeckillPersonRpc;

import javax.annotation.Resource;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.facade
 * @className: SeckillPersonGrpc
 * @date 2023/4/18
 * @description: 接口层
 */
@GrpcService
public class SeckillPersonGrpc extends person.SeckillPersonServiceGrpc.SeckillPersonServiceImplBase {
    @Resource
    PersonApplication personApplication;
    private final String lockKey = "PERSON-";

    @Override
    public void create(SeckillPersonRpc.PersonMessage.CreatePersonReq request, StreamObserver<SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
        SeckillPersonRpc.PersonMessage.CommonRely.Builder builder = SeckillPersonRpc.PersonMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "CREATE-" + request.getUserName(), 500, () -> {
            Person person = PersonMapper.INSTANCE.toEntity(request);
            personApplication.save(person);
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void update(SeckillPersonRpc.PersonMessage.UpdatePersonReq request, StreamObserver<SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
        SeckillPersonRpc.PersonMessage.CommonRely.Builder builder = SeckillPersonRpc.PersonMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "UPDATE-" + request.getUserName(), 500, () -> {
            Person person = PersonMapper.INSTANCE.toEntity(request);
            personApplication.update(person);
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void login(SeckillPersonRpc.PersonMessage.PersonLoginReq request, StreamObserver<SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
        super.login(request, responseObserver);
    }
}
