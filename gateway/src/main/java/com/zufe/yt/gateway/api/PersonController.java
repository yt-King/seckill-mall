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
    @GrpcClient("collection")
    private person.SeckillCollectionServiceGrpc.SeckillCollectionServiceBlockingStub collectionStub;
    @GrpcClient("shopping-cart")
    private person.SeckillShoppingCartServiceGrpc.SeckillShoppingCartServiceBlockingStub shoppingCartStub;

    @PostMapping(value = "/v1/create")
    public JSONObject create(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.PersonMessage.CommonRely rely = personStub.create(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.PersonMessage.CreatePersonReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/judge")
    public JSONObject judge(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.PersonMessage.CommonRely rely = personStub.judgeExistence(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.PersonMessage.JudgeExistenceReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/login")
    public JSONObject login(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.PersonMessage.PersonLoginRely rely = personStub.login(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.PersonMessage.PersonLoginReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/addCollection")
    public JSONObject addCollection(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.CollectionMessage.CommonRely rely = collectionStub.addCollect(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.CollectionMessage.AddCollectionReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/deleteCollection")
    public JSONObject deleteCollection(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.CollectionMessage.CommonRely rely = collectionStub.deleteCollect(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.CollectionMessage.DeleteCollectReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/getCollection")
    public JSONObject getCollection(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.CollectionMessage.GetCollectRely rely = collectionStub.getCollect(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.CollectionMessage.GetCollectReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/addShoppingCart")
    public JSONObject addShoppingCart(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.ShoppingCartMessage.AddShoppingCartRely rely = shoppingCartStub.addShoppingCart(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.ShoppingCartMessage.AddShoppingCartReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/updateShoppingCart")
    public JSONObject updateShoppingCart(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.ShoppingCartMessage.CommonRely rely = shoppingCartStub.updateShoppingCart(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.ShoppingCartMessage.UpdateShoppingCartReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/deleteShoppingCart")
    public JSONObject deleteShoppingCart(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.ShoppingCartMessage.CommonRely rely = shoppingCartStub.deleteShoppingCart(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.ShoppingCartMessage.DeleteShoppingCartReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/getShoppingCart")
    public JSONObject getShoppingCart(@RequestBody Map<String, Object> data) {
        SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartRely rely = shoppingCartStub.getShoppingCart(ProtoBeanUtil.toMessage(data, SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }
}
