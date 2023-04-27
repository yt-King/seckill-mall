package com.zufe.yt.order.domain.order.entity;

import com.zufe.yt.order.domain.order.value.Num;
import com.zufe.yt.order.domain.order.value.Price;
import com.zufe.yt.order.domain.order.value.ProductId;
import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.order.domain.order.value
 * @className: Order
 * @date 2023/4/27
 * @description: 子订单实体
 */
@Data
public class ChildOrder {
    String id;
    /**
     * 商品id
     */
    ProductId productId;
    /**
     * 商品价格
     */
    Price price;
    /**
     * 商品数量
     */
    Num num;
    /**
     * 订单状态
     */
    String status;
}
