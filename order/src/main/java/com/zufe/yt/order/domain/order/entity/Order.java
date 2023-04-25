package com.zufe.yt.order.domain.order.entity;

import com.zufe.yt.order.domain.order.value.Price;
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
     * 商品价格
     */
    Price price;
    /**
     * 商品数量
     */
    Integer num;
    /**
     * 创建时间
     */
    Double createTime;
}
