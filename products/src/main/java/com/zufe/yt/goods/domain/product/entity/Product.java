package com.zufe.yt.goods.domain.product.entity;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.goods.domain.product.repository.ProductsRepository;
import com.zufe.yt.goods.infrastructure.enums.CategoryEnum;
import com.zufe.yt.goods.infrastructure.util.EnumListUtil;
import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.goods.domain.product.entity
 * @className: Product
 * @date 2023/4/23
 * @description: 商品实体类
 */

@Data
public class Product {
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

    public void valid() {
        if (StrUtil.isBlank(this.productId)) {
            throw new ServiceException("商品id不能为空", 100001);
        }
        if (StrUtil.isBlank(this.productName)) {
            throw new ServiceException("商品名称不能为空", 100001);
        }
        if (null == this.categoryId || 0 == this.categoryId) {
            throw new ServiceException("类目id不能为空", 100001);
        } else {
            String key = "categoryId";
            if (EnumListUtil.enumToListMap(CategoryEnum.class).parallelStream().map(x -> (int) x.get(key)).noneMatch(x -> this.categoryId.intValue() == x)) {
                throw new ServiceException("类目id错误", 100001);
            }
        }
        if (this.productPrice == null || this.productSellingPrice == null) {
            throw new ServiceException("商品价格不能为空", 100001);
        } else {
            if (this.productPrice <= 0 || this.productSellingPrice <= 0) {
                throw new ServiceException("商品价格不能为负数", 100001);
            }
        }
        if (this.productNum == null || this.productNum <= 0) {
            throw new ServiceException("商品数量错误", 100001);
        }
    }

    public void validExistence(ProductsRepository productsRepository) {
        Product find = productsRepository.find(new CriteriaAndWrapper().eq(Product::getProductId, this.productId));
        if (null != find) {
            throw new ServiceException("商品已存在", 100001);
        }
    }
}
