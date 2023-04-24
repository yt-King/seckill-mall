package com.zufe.yt.goods.interfaces.dto;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.goods.interfaces.dto
 * @className: ProductDTO
 * @date 2023/4/23
 * @description: TODO
 */

@Data
public class ProductDTO {
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
     * 商品介绍
     */
    String productIntro;
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
    /**
     * 商品数量
     */
    Integer productNum;
    /**
     * 商品售出
     */
    Integer productSales;
}
