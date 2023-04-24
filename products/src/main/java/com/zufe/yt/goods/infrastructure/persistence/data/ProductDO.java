package com.zufe.yt.goods.infrastructure.persistence.data;

import com.zufe.yt.common.mongo.util.MongoBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yt
 * @package: com.zufe.yt.goods.infrastructure.persistence.data
 * @className: ProductDO
 * @date 2023/4/23
 * @description: 商品持久化对象
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "products")
public class ProductDO extends MongoBaseDO {
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
    /**
     * 全局搜索值
     */
    String globalSearchValue;
}
