package com.zufe.yt.order.domain.order.value;

import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;

/**
 * @author yt
 * @package: com.zufe.yt.order.domain.order.value
 * @className: Num
 * @date 2023/4/27
 * @description: 数量值对象
 */
public class Num implements ValueObject<Num> {
    private final Integer value;

    public Num(Integer value) {
        if (null == value) {
            throw new ServiceException("商品数量不能为空", 100001);
        }
        if (value <= 0) {
            throw new ServiceException("商品数量不能为负数", 100001);
        }
        this.value = value;
    }

    @Override
    public boolean sameValueAs(Num other) {
        return false;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
