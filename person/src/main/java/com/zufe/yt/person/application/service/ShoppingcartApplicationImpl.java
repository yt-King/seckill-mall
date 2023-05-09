package com.zufe.yt.person.application.service;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.person.application.ShoppingcartApplication;
import com.zufe.yt.person.domain.shoppingcart.entity.ShoppingCart;
import com.zufe.yt.person.domain.shoppingcart.repository.ShoppingcartRepository;
import com.zufe.yt.person.infrastructure.transfer.ShoppingcartMapper;
import com.zufe.yt.person.interfaces.dto.ShoppingcartInfoDTO;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import person.SeckillPersonRpc;
import product.SeckillProductRpc;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yt
 * @package: com.zufe.yt.person.application.service
 * @className: ShoppingcartApplicationImpl
 * @date 2023/4/29
 * @description: TODO
 */

@Service
public class ShoppingcartApplicationImpl implements ShoppingcartApplication {
    @Resource
    ShoppingcartRepository shoppingcartRepository;
    @GrpcClient("products")
    product.SeckillProductServiceGrpc.SeckillProductServiceBlockingStub productsStub;

    @Override
    public SeckillPersonRpc.ShoppingCartMessage.ShoppingCart save(ShoppingCart shoppingCart) {
        shoppingCart.valid();
        String productId = shoppingcartRepository.saveOrUpdate(shoppingCart);
        if (StrUtil.isNotBlank(productId)) {
            //不为空表示新增的，返回的是productId，把商品信息查出来返回
            SeckillProductRpc.ProductMessage.Product product = productsStub.getProductDetail(SeckillProductRpc.ProductMessage.GetProductDetailReq.newBuilder().setId(productId).build()).getProduct();
            return SeckillPersonRpc.ShoppingCartMessage.ShoppingCart
                    .newBuilder()
                    .setStock(product.getProductStock())
                    .setPrice(product.getProductSellingPrice())
                    .setProductId(product.getId())
                    .setProductName(product.getProductName())
                    .setProductPicture(product.getProductPicture())
                    .setNum(1)
                    .build();
        }
        return null;
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        shoppingCart.valid();
        shoppingCart.validExistence(shoppingcartRepository);
        shoppingcartRepository.updateNum(shoppingCart);
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        shoppingCart.valid();
        shoppingCart.validExistence(shoppingcartRepository);
        shoppingcartRepository.delete(shoppingCart);
    }

    @Override
    public List<ShoppingcartInfoDTO> getShoppingCart(String userId) {
        if (StrUtil.isBlank(userId)) {
            throw new ServiceException("用户id不能为空", 100001);
        }
        ShoppingCart shoppingCart = shoppingcartRepository.find(new CriteriaAndWrapper().eq(ShoppingCart::getUserId, userId));
        Map<String, SeckillProductRpc.ProductMessage.SimpleProduct> simpleProductMap =
                productsStub.getAllProducts(SeckillProductRpc.ProductMessage.GetTotalProductsReq.newBuilder().build())
                        .getProductList().parallelStream().collect(Collectors.toMap(SeckillProductRpc.ProductMessage.SimpleProduct::getId, x -> x));
        List<ShoppingcartInfoDTO> list = new ArrayList<>();
        if (shoppingCart != null) {
            shoppingCart.getProductInfos().forEach(x -> {
                ShoppingcartInfoDTO dto = ShoppingcartMapper.INSTANCE.toDTO(simpleProductMap.get(x.getProductId()));
                dto.setNum(x.getNum());
                list.add(dto);
            });
        }
        return list;
    }
}
