package com.zufe.yt.gateway.api;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.SeckillPersonRpc;
import person.SeckillPersonServiceGrpc;

/**
 * @author yt
 * @package: com.zufe.yt.gateway.api
 * @className: PersonController
 * @date 2023/4/20
 * @description: 用户http接口层
 */

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @GrpcClient("person")
    SeckillPersonServiceGrpc.SeckillPersonServiceBlockingStub personStub;

    @PostMapping(value = "/admin/v1/create")
    public SeckillPersonRpc.PersonMessage.CommonRely create(@RequestBody SeckillPersonRpc.PersonMessage.CreatePersonReq req) {
        return personStub.create(req);
    }
}
