package com.zufe.yt.order.domain.order.value;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;

/**
 * @author yt
 * @package: com.zufe.yt.order.domain.order.value
 * @className: ProductId
 * @date 2023/4/27
 * @description: 商品id值对象
 */
public class ProductId implements ValueObject<ProductId> {
    private final String value;

    public ProductId(String value) {
        if (StrUtil.isBlank(value)) {
            throw new ServiceException("商品id不能为空", 100001);
        }
        this.value = value;
    }

    @Override
    public boolean sameValueAs(ProductId other) {
        return false;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
