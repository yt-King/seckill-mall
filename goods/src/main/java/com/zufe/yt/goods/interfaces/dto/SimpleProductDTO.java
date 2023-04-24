package com.zufe.yt.goods.interfaces.dto;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.goods.interfaces.dto
 * @className: ProductDTO
 * @date 2023/4/23
 * @description: 商品列表dto
 */

@Data
public class SimpleProductDTO {
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
    Integer productPrice;
    /**
     * 商品打折价格
     */
    Integer productSellingPrice;
}
