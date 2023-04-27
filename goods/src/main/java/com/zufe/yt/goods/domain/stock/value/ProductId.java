package com.zufe.yt.goods.domain.stock.value;

import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yt
 * @package: com.zufe.yt.goods.domain.stock.value
 * @className: GoodsId
 * @date 2023/4/26
 * @description: 商品id值对象
 */
@Getter
public class ProductId implements ValueObject<ProductId> {
    private final String value;

    public ProductId(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new ServiceException("商品id不能为空", 103005);
        }
        this.value = value;
    }

    @Override
    public boolean sameValueAs(ProductId other) {
        return other != null && this.value.equals(other.getValue());
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}