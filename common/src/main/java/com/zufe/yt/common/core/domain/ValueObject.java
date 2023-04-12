package com.zufe.yt.common.core.domain;

import java.io.Serializable;

/**
 * 值对象接口
 *
 * @author 秋玖壹
 **/
public interface ValueObject<T> extends Serializable {
    /**
     * 值对象通过其属性的值进行比较
     *
     * @param other 其他值对象
     * @return 给定值对象的属性与该值对象的属性是否相同
     */
    boolean sameValueAs(T other);

    /**
     * 获取值对象的值
     *
     * @return 值
     */
    Object getValue();
}
