package com.zufe.yt.person.interfaces.dto;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.dto
 * @className: ShoppingcartInfoDTO
 * @date 2023/4/30
 * @description: TODO
 */
@Data
public class ShoppingcartInfoDTO {
    /**
     * 主键id
     */
    String id;
    /**
     * 类目id
     */
    Integer categoryId;
    /**
     * 商品id
     */
    String productId;
    /**
     * 商品名称
     */
    String productName;
    /**
     * 商品标题
     */
    String productTitle;
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
