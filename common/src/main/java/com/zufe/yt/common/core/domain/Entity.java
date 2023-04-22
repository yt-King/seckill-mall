package com.zufe.yt.common.core.domain;

import java.io.Serializable;

/**
 * 实体接口
 *
 * @author 秋玖壹
 **/
public interface Entity<T> extends Serializable {

    /**
     * 根据身份而不是属性进行比较
     *
     * @param other 其他实体
     * @return 如果标识相同，则为True，无论其他属性如何
     */
    boolean sameIdentityAs(T other);
}
