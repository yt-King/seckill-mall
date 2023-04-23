package com.zufe.yt.goods.domain.category.entity;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.goods.domain.category.entity
 * @className: Category
 * @date 2023/4/23
 * @description: 商品类目实体
 */

@Data
public class Category {
    /**
     * 类目id
     */
    Integer categoryId;
    /**
     * 类目名称
     */
    String categoryName;
}
