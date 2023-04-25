package com.zufe.yt.order.interfaces.dto;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.order.interfaces.dto
 * @className: OrderDTO
 * @date 2023/4/24
 * @description: 订单dto
 */

@Data
public class OrderDTO {
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
    Integer price;
    /**
     * 商品数量
     */
    Integer num;
    /**
     * 创建时间
     */
    Double createTime;
}
