package com.zufe.yt.gateway.api;

import com.alibaba.fastjson.JSONObject;
import com.zufe.yt.gateway.util.ProtoBeanUtil;
import net.devh.boot.grpc.client.inject.GrpcClient;
import order.SeckillOrderRpc;
import order.SeckillOrderServiceGrpc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yt
 * @package: com.zufe.yt.gateway.api
 * @className: PersonController
 * @date 2023/4/20
 * @description: 用户http接口层
 */

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @GrpcClient("order")
    private SeckillOrderServiceGrpc.SeckillOrderServiceBlockingStub orderStub;

    @PostMapping(value = "/v1/add")
    public JSONObject add(@RequestBody Map<String, Object> data) {
        SeckillOrderRpc.OrderMessage.CommonRely rely = orderStub.addOrder(ProtoBeanUtil.toMessage(data, SeckillOrderRpc.OrderMessage.AddOrderReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/get")
    public JSONObject get(@RequestBody Map<String, Object> data) {
        SeckillOrderRpc.OrderMessage.GetOrderRely rely = orderStub.getOrder(ProtoBeanUtil.toMessage(data, SeckillOrderRpc.OrderMessage.GetOrderReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }
}
