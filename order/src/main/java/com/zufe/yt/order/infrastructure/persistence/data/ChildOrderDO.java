package com.zufe.yt.order.infrastructure.persistence.data;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.order.infrastructure.persistence.data
 * @className: ChildOrderDO
 * @date 2023/4/27
 * @description: TODO
 */

@Data
public class ChildOrderDO {
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
