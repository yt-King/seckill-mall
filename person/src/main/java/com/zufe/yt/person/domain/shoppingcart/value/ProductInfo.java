package com.zufe.yt.person.domain.shoppingcart.value;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;
import lombok.Getter;

/**
 * @author yt
 * @package: com.zufe.yt.person.domain.shoppingcart.value
 * @className: ProductInfo
 * @date 2023/4/29
 * @description: TODO
 */
@Getter
public class ProductInfo implements ValueObject<ProductInfo> {
    private final String productId;
    private final Integer num;

    public ProductInfo(String productId, Integer num) {
        if (StrUtil.isBlank(productId)) {
            throw new ServiceException("商品id不能为空", 100001);
        }
        if (num == null || num == 0) {
            throw new ServiceException("操作数量不正确", 100001);
        }
        if (num > 10) {
            throw new ServiceException("超过最大可购买限制", 100001);
        }
        this.num = num;
        this.productId = productId;
    }

    @Override
    public boolean sameValueAs(ProductInfo other) {
        return false;
    }

    @Override
    public ProductInfo getValue() {
        return this;
    }
}
