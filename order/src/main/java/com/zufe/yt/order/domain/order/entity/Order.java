package com.zufe.yt.order.domain.order.entity;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.order.domain.order.entity
 * @className: order
 * @date 2023/4/24
 * @description: 订单实体类
 */

@Data
public class Order {
    /**
     * id
     */
    String id;
    /**
     * 商品id
     */
    String productId;
    /**
     * 商品名称
     */
    String productName;
    /**
     * 商品图片
     */
    String productPicture;
    /**
     * 商品价格
     */
    Integer price;
    /**
     * 商品数量
     */
    Integer num;
}
