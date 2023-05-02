package com.zufe.yt.person.infrastructure.persistence.repository;

import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.person.domain.shoppingcart.entity.ShoppingCart;
import com.zufe.yt.person.domain.shoppingcart.repository.ShoppingcartRepository;
import com.zufe.yt.person.domain.shoppingcart.value.ProductInfo;
import com.zufe.yt.person.infrastructure.persistence.data.ShoppingcartDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.infrastructure.persistence.repository
 * @className: ShoppingcartRepositoryImpl
 * @date 2023/4/29
 * @description: TODO
 */
@Repository
public class ShoppingcartRepositoryImpl extends RepositoryImpl<ShoppingCart, ShoppingcartDO> implements ShoppingcartRepository {
    @Override
    public String saveOrUpdate(ShoppingCart shoppingCart) {
        ShoppingCart find = super.find(new CriteriaAndWrapper().eq(ShoppingcartDO::getUserId, shoppingCart.getUserId()));
        if (find == null) {
            //第一次直接新增
            super.saveOrUpdate(shoppingCart);
            return shoppingCart.getProductInfos().get(0).getProductId();
        }
        String productId = shoppingCart.getProductInfos().get(0).getProductId();
        List<String> productIds = find.getProductInfos().parallelStream().map(ProductInfo::getProductId).toList();
        if (productIds.contains(productId)) {
            //如果已经在购物车就加1
            ProductInfo productInfo = find.getProductInfos().parallelStream().filter(x -> x.getProductId().equals(productId)).findAny().get();
            find.getProductInfos().remove(productInfo);
            find.getProductInfos().add(new ProductInfo(productId, productInfo.getNum() + 1));
            super.saveOrUpdate(find);
            //返回空字符串用作特殊判断
            return "";
        }
        find.getProductInfos().add(shoppingCart.getProductInfos().get(0));
        super.saveOrUpdate(find);
        return shoppingCart.getProductInfos().get(0).getProductId();
    }

    @Override
    public String updateNum(ShoppingCart shoppingCart) {
        ShoppingCart find = super.find(new CriteriaAndWrapper().eq(ShoppingcartDO::getUserId, shoppingCart.getUserId()));
        ProductInfo info = shoppingCart.getProductInfos().get(0);
        find.getProductInfos().removeIf(x -> x.getProductId().equals(info.getProductId()));
        find.getProductInfos().add(new ProductInfo(info.getProductId(), info.getNum()));
        return super.saveOrUpdate(find);
    }

    @Override
    public String delete(ShoppingCart shoppingCart) {
        ShoppingCart find = super.find(new CriteriaAndWrapper().eq(ShoppingcartDO::getUserId, shoppingCart.getUserId()));
        List<String> list = shoppingCart.getProductInfos().parallelStream().map(ProductInfo::getProductId).toList();
        find.getProductInfos().removeIf(x -> list.contains(x.getProductId()));
        return super.saveOrUpdate(find);
    }
}
