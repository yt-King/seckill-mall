package com.zufe.yt.gateway.api;

import com.alibaba.fastjson.JSONObject;
import com.zufe.yt.gateway.util.ProtoBeanUtil;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.SeckillPersonRpc;
import person.SeckillPersonServiceGrpc;

import java.util.Map;

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
    private SeckillPersonServiceGrpc.SeckillPersonServiceBlockingStub personStub;

    @PostMapping(value = "/v1/create")
    public JSONObject create(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.PersonMessage.CommonRely rely = personStub.create(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.PersonMessage.CreatePersonReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }
}
