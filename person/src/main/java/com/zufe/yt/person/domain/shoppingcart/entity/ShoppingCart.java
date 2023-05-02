package com.zufe.yt.person.domain.shoppingcart.entity;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.person.domain.shoppingcart.repository.ShoppingcartRepository;
import com.zufe.yt.person.domain.shoppingcart.value.ProductInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.domain.person.entity.value
 * @className: order
 * @date 2023/4/11
 * @description: 用户购物车实体
 */

@Data
@Builder
public class ShoppingCart {
    private String id;
    private String userId;
    private List<ProductInfo> productInfos;

    public void valid() {
        if (StrUtil.isBlank(this.userId)) {
            throw new ServiceException("用户id不能为空", 100001);
        }
        if (this.productInfos.isEmpty()) {
            throw new ServiceException("添加商品信息有误", 100001);
        }
    }

    public void validExistence(ShoppingcartRepository shoppingcartRepository) {
        ShoppingCart find = shoppingcartRepository.find(new CriteriaAndWrapper().eq(ShoppingCart::getUserId, this.userId));
        if (find == null) {
            throw new ServiceException("购物车不存在", 100001);
        }
        List<ProductInfo> res = find.getProductInfos().parallelStream().filter(x -> x.getProductId().equals(this.productInfos.get(0).getProductId())).toList();
        if(res.isEmpty()){
            throw new ServiceException("所选商品不存在", 100001);
        }
    }
}
