package com.zufe.yt.order.domain.order.value;

import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;
import lombok.Getter;

/**
 * @author yt
 * @package: com.zufe.yt.order.domain.order.value
 * @className: price
 * @date 2023/4/24
 * @description: 价格值对象
 */

@Getter
public class Price implements ValueObject<Price> {
    private final Integer value;

    public Price(Integer value) {
        if (null == value) {
            throw new ServiceException("商品价格不能为空", 100001);
        }
        if (value <= 0) {
            throw new ServiceException("商品价格不能为负数", 100001);
        }
        this.value = value;
    }

    @Override
    public boolean sameValueAs(Price other) {
        return false;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
