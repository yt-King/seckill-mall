package com.zufe.yt.common.mongo.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 默认更新时间
 *
 * @author 秋玖壹
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UpdateTime {
}
