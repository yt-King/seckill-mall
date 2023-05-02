package com.zufe.yt.person.interfaces.facade;

import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.common.redis.util.LockUtil;
import com.zufe.yt.person.application.ShoppingcartApplication;
import com.zufe.yt.person.domain.shoppingcart.entity.ShoppingCart;
import com.zufe.yt.person.domain.shoppingcart.value.ProductInfo;
import com.zufe.yt.person.infrastructure.transfer.ShoppingcartMapper;
import com.zufe.yt.person.interfaces.dto.ShoppingcartInfoDTO;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import person.SeckillPersonRpc;
import person.SeckillShoppingCartServiceGrpc;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.facade
 * @className: SeckillShoppingcartGrpc
 * @date 2023/4/25
 * @description: 接口层
 */

@GrpcService
public class SeckillShoppingcartGrpc extends SeckillShoppingCartServiceGrpc.SeckillShoppingCartServiceImplBase {
    @Resource
    ShoppingcartApplication shoppingcartApplication;
    private final String lockKey = "SHOPPING-";

    @Override
    public void addShoppingCart(SeckillPersonRpc.ShoppingCartMessage.AddShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.AddShoppingCartRely> responseObserver) {
        SeckillPersonRpc.ShoppingCartMessage.AddShoppingCartRely.Builder builder = SeckillPersonRpc.ShoppingCartMessage.AddShoppingCartRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "ADD-" + request.getUserId(), 500, () -> {
            SeckillPersonRpc.ShoppingCartMessage.ShoppingCart res = shoppingcartApplication.save(ShoppingCart.builder().userId(request.getUserId()).productInfos(List.of(new ProductInfo(request.getProductId(), 1))).build());
            if (res != null) {
                builder.setShoppingCartData(res);
            } else {
                builder.setCode(1);
            }
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteShoppingCart(SeckillPersonRpc.ShoppingCartMessage.DeleteShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.CommonRely> responseObserver) {
        SeckillPersonRpc.ShoppingCartMessage.CommonRely.Builder builder = SeckillPersonRpc.ShoppingCartMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "DELETE-" + request.getUserId(), 500, () -> {
            shoppingcartApplication.delete(ShoppingCart.builder().userId(request.getUserId()).productInfos(request.getProductIdList().parallelStream().map(x -> new ProductInfo(x, 1)).toList()).build());
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateShoppingCart(SeckillPersonRpc.ShoppingCartMessage.UpdateShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.CommonRely> responseObserver) {
        SeckillPersonRpc.ShoppingCartMessage.CommonRely.Builder builder = SeckillPersonRpc.ShoppingCartMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "UPDATE-" + request.getUserId(), 500, () -> {
            shoppingcartApplication.update(ShoppingCart.builder().userId(request.getUserId()).productInfos(List.of(new ProductInfo(request.getProductId(), request.getNum()))).build());
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getShoppingCart(SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartRely> responseObserver) {
        SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartRely.Builder builder = SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        List<ShoppingcartInfoDTO> list = shoppingcartApplication.getShoppingCart(request.getUserId());
        list.forEach(x -> builder.addShoppingCartData(ShoppingcartMapper.INSTANCE.toMessage(x)));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
