package com.zufe.yt.person.interfaces.facade;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import person.SeckillPersonRpc;
import person.SeckillShoppingCartServiceGrpc;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.facade
 * @className: SeckillShoppingcartGrpc
 * @date 2023/4/25
 * @description: 接口层
 */

@GrpcService
public class SeckillShoppingcartGrpc extends SeckillShoppingCartServiceGrpc.SeckillShoppingCartServiceImplBase {
    @Override
    public void addShoppingCart(SeckillPersonRpc.ShoppingCartMessage.AddShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.CommonRely> responseObserver) {
        super.addShoppingCart(request, responseObserver);
    }

    @Override
    public void deleteShoppingCart(SeckillPersonRpc.ShoppingCartMessage.DeleteShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.CommonRely> responseObserver) {
        super.deleteShoppingCart(request, responseObserver);
    }

    @Override
    public void updateShoppingCart(SeckillPersonRpc.ShoppingCartMessage.UpdateShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.CommonRely> responseObserver) {
        super.updateShoppingCart(request, responseObserver);
    }

    @Override
    public void getShoppingCart(SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartReq request, StreamObserver<SeckillPersonRpc.ShoppingCartMessage.GetShoppingCartRely> responseObserver) {
        super.getShoppingCart(request, responseObserver);
    }
}
