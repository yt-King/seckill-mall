package com.zufe.yt.goods.interfaces.facade;

import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.common.redis.util.LockUtil;
import com.zufe.yt.goods.application.ProductsApplication;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.infrastructure.transfer.CategoryMapper;
import com.zufe.yt.goods.infrastructure.transfer.ProductMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import product.SeckillProductRpc;
import product.SeckillProductServiceGrpc;

import javax.annotation.Resource;

/**
 * @author yt
 * @package: com.zufe.yt.products.interfaces.facade
 * @className: SeckillProductsGrpc
 * @date 2023/4/23
 * @description: 商品接口层
 */

@GrpcService
public class SeckillProductsGrpc extends SeckillProductServiceGrpc.SeckillProductServiceImplBase {
    @Resource
    private ProductsApplication productsApplication;

    private final String lockKey = "PRODUCT-";

    @Override
    public void saveOrUpdateProduct(SeckillProductRpc.ProductMessage.SaveOrUpdateProductReq request, StreamObserver<SeckillProductRpc.ProductMessage.CommonRely> responseObserver) {
        SeckillProductRpc.ProductMessage.CommonRely.Builder builder = SeckillProductRpc.ProductMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "SAVE-UPDATE-" + request.getProductId(), 500, () -> {
            Product product = ProductMapper.INSTANCE.toEntity(request);
            productsApplication.saveOrUpdate(product);
        });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteProduct(SeckillProductRpc.ProductMessage.DeleteProductReq request, StreamObserver<SeckillProductRpc.ProductMessage.CommonRely> responseObserver) {
        SeckillProductRpc.ProductMessage.CommonRely.Builder builder = SeckillProductRpc.ProductMessage.CommonRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        LockUtil.lock(lockKey + "DELETE-" + request.getId(), 500, () -> productsApplication.delete(request.getId()));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCategory(SeckillProductRpc.ProductMessage.GetCategoryReq request, StreamObserver<SeckillProductRpc.ProductMessage.GetCategoryRely> responseObserver) {
        SeckillProductRpc.ProductMessage.GetCategoryRely.Builder builder = SeckillProductRpc.ProductMessage.GetCategoryRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        productsApplication.getCategory().forEach(x -> builder.addCategory(CategoryMapper.INSTANCE.toMessage(x)));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getProducts(SeckillProductRpc.ProductMessage.GetAllProductsReq request, StreamObserver<SeckillProductRpc.ProductMessage.GetAllProductsRely> responseObserver) {
        SeckillProductRpc.ProductMessage.GetAllProductsRely.Builder builder = SeckillProductRpc.ProductMessage.GetAllProductsRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        productsApplication.getProductList(ProductMapper.INSTANCE.toQuery(request)).forEach(x -> builder.addProduct(ProductMapper.INSTANCE.toMessage(x)));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
