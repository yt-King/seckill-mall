package com.zufe.yt.order.domain.order.value;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;
import lombok.Getter;

/**
 * @author yt
 * @package: com.zufe.yt.order.domain.order.value
 * @className: price
 * @date 2023/4/24
 * @description: 名称值对象
 */

@Getter
public class Name implements ValueObject<Name> {
    private final String value;

    public Name(String value) {
        if (StrUtil.isBlank(value)) {
            throw new ServiceException("名称不能为空", 100001);
        }
        this.value = value;
    }

    @Override
    public boolean sameValueAs(Name other) {
        return false;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
