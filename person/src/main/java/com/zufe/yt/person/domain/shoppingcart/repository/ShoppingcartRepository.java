package com.zufe.yt.person.domain.shoppingcart.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.person.domain.shoppingcart.entity.ShoppingCart;
import com.zufe.yt.person.infrastructure.persistence.data.ShoppingcartDO;

/**
 * @author yt
 * @date 2023/4/29
 * @description: TODO
 */
public interface ShoppingcartRepository extends IRepository<ShoppingCart, ShoppingcartDO> {
    @Override
    String saveOrUpdate(ShoppingCart shoppingCart);

    String updateNum(ShoppingCart shoppingCart);

    String delete(ShoppingCart shoppingCart);
}
