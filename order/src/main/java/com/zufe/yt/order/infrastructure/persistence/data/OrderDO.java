package com.zufe.yt.order.infrastructure.persistence.data;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.order.infrastructure.persistence.data
 * @className: OrderDO
 * @date 2023/4/24
 * @description: 订单持久化对象
 */

@Data
public class OrderDO {
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
