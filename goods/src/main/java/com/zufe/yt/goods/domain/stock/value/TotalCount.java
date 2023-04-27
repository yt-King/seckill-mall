package com.zufe.yt.goods.domain.stock.value;

import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;
import lombok.Getter;

/**
 * @author yt
 * @package: com.zufe.yt.goods.domain.stock.value
 * @className: GoodsId
 * @date 2023/4/26
 * @description: 商品总量值对象
 */
@Getter
public class TotalCount implements ValueObject<TotalCount> {
    private final Integer value;

    public TotalCount(Integer value) {
        if (value == null) {
            throw new ServiceException("商品总量不能为空", 103005);
        }
        if (value < 0) {
            throw new ServiceException("商品总量不能为负数", 103005);
        }
        this.value = value;
    }

    @Override
    public boolean sameValueAs(TotalCount other) {
        return other != null && this.value.equals(other.getValue());
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}