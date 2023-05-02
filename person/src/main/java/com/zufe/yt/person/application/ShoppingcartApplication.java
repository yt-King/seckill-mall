package com.zufe.yt.person.application;

import com.zufe.yt.person.domain.shoppingcart.entity.ShoppingCart;
import com.zufe.yt.person.interfaces.dto.ShoppingcartInfoDTO;
import person.SeckillPersonRpc;

import java.util.List;

/**
 * @author yt
 * @date 2023/4/29
 * @description: TODO
 */
public interface ShoppingcartApplication {
    /**
     * 新增
     */
    SeckillPersonRpc.ShoppingCartMessage.ShoppingCart save(ShoppingCart shoppingCart);

    /**
     * 更新
     */
    void update(ShoppingCart shoppingCart);

    /**
     * 删除
     */
    void delete(ShoppingCart shoppingCart);

    /**
     * 购物车详情
     */
    List<ShoppingcartInfoDTO> getShoppingCart(String userId);
}
