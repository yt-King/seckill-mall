package com.zufe.yt.order.interfaces.dto;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.order.interfaces.dto
 * @className: ChildOrderDTO
 * @date 2023/4/27
 * @description: 子订单dto
 */

@Data
public class ChildOrderDTO {
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
     * 订单状态
     */
    String status;
}
