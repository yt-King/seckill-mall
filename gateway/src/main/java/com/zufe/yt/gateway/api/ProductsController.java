package com.zufe.yt.gateway.api;

import com.alibaba.fastjson.JSONObject;
import com.zufe.yt.gateway.util.ProtoBeanUtil;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.SeckillProductRpc;
import product.SeckillProductServiceGrpc;

import java.util.Map;

/**
 * @author yt
 * @package: com.zufe.yt.gateway.api
 * @className: ProductsController
 * @date 2023/4/23
 * @description: 商品http接口层
 */

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    @GrpcClient("products")
    SeckillProductServiceGrpc.SeckillProductServiceBlockingStub productsStub;

    @PostMapping(value = "/v1/create")
    public JSONObject create(@RequestBody Map<String, Object> data) {
        SeckillProductRpc.ProductMessage.CommonRely rely = productsStub.saveOrUpdateProduct(ProtoBeanUtil.toMessage(data, SeckillProductRpc.ProductMessage.SaveOrUpdateProductReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/update")
    public JSONObject update(@RequestBody Map<String, Object> data) {
        SeckillProductRpc.ProductMessage.CommonRely rely = productsStub.saveOrUpdateProduct(ProtoBeanUtil.toMessage(data, SeckillProductRpc.ProductMessage.SaveOrUpdateProductReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/category")
    public JSONObject category(@RequestBody Map<String, Object> data) {
        SeckillProductRpc.ProductMessage.GetCategoryRely rely = productsStub.getCategory(ProtoBeanUtil.toMessage(data, SeckillProductRpc.ProductMessage.GetCategoryReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/products")
    public JSONObject products(@RequestBody Map<String, Object> data) {
        SeckillProductRpc.ProductMessage.GetAllProductsRely rely = productsStub.getProducts(ProtoBeanUtil.toMessage(data, SeckillProductRpc.ProductMessage.GetAllProductsReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }

    @PostMapping(value = "/v1/detail")
    public JSONObject detail(@RequestBody Map<String, Object> data) {
        SeckillProductRpc.ProductMessage.GetProductDetailRely rely = productsStub.getProductDetail(ProtoBeanUtil.toMessage(data, SeckillProductRpc.ProductMessage.GetProductDetailReq.newBuilder()).build());
        return ProtoBeanUtil.toBean(rely, JSONObject.class);
    }
}
