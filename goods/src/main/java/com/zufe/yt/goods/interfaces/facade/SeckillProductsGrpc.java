package com.zufe.yt.goods.interfaces.facade;

import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.common.mongo.util.MongoPage;
import com.zufe.yt.common.redis.util.LockUtil;
import com.zufe.yt.goods.application.ProductsApplication;
import com.zufe.yt.goods.domain.carousel.Carousel;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.infrastructure.transfer.CarouselMapper;
import com.zufe.yt.goods.infrastructure.transfer.CategoryMapper;
import com.zufe.yt.goods.infrastructure.transfer.ProductMapper;
import com.zufe.yt.goods.infrastructure.transfer.StockMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import product.SeckillProductRpc;
import product.SeckillProductServiceGrpc;

import javax.annotation.Resource;
import java.util.List;

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
        LockUtil.lock(lockKey + "DELETE-" + request.getId(), 500, () -> productsApplication.delete(ProductMapper.INSTANCE.toCacheQuery(request)));
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
        MongoPage<Product> mongoPage = productsApplication.getProductList(ProductMapper.INSTANCE.toQuery(request));
        mongoPage.getRecords().forEach(x -> builder.addProduct(ProductMapper.INSTANCE.toSimpleMessage(x)));
        builder.setTotal((int) mongoPage.getTotalSize());
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProducts(SeckillProductRpc.ProductMessage.GetTotalProductsReq request, StreamObserver<SeckillProductRpc.ProductMessage.GetTotalProductsRely> responseObserver) {
        SeckillProductRpc.ProductMessage.GetTotalProductsRely.Builder builder = SeckillProductRpc.ProductMessage.GetTotalProductsRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        List<Product> list = productsApplication.getAllProductList();
        list.forEach(x -> builder.addProduct(ProductMapper.INSTANCE.toSimpleMessage(x)));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();    }

    @Override
    public void getProductDetail(SeckillProductRpc.ProductMessage.GetProductDetailReq request, StreamObserver<SeckillProductRpc.ProductMessage.GetProductDetailRely> responseObserver) {
        SeckillProductRpc.ProductMessage.GetProductDetailRely.Builder builder = SeckillProductRpc.ProductMessage.GetProductDetailRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        Product productDetail = productsApplication.getProductDetail(ProductMapper.INSTANCE.toCacheQuery(request));
        builder.setProduct(ProductMapper.INSTANCE.toMessage(productDetail));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void incGotCount(SeckillProductRpc.ProductMessage.IncGotCountReq request, StreamObserver<SeckillProductRpc.ProductMessage.IncGotCountRely> responseObserver) {
        SeckillProductRpc.ProductMessage.IncGotCountRely.Builder builder = SeckillProductRpc.ProductMessage.IncGotCountRely.newBuilder();
        //不加锁，内部实现扣库存原子化同时返回唯一标识
        String codeId = productsApplication.incCount(StockMapper.INSTANCE.toDTO(request));
        builder.setCodeId(codeId);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCarousel(SeckillProductRpc.ProductMessage.GetCarouselReq request, StreamObserver<SeckillProductRpc.ProductMessage.GetCarouselRely> responseObserver) {
        SeckillProductRpc.ProductMessage.GetCarouselRely.Builder builder = SeckillProductRpc.ProductMessage.GetCarouselRely.newBuilder().setCode(ResultCode.SUCCESS.getCode());
        List<Carousel> list = productsApplication.getCarousel();
        for (Carousel carousel : list) {
            builder.addCarousel(CarouselMapper.INSTANCE.toMessage(carousel));
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
