package com.zufe.yt.common.mongo.util;

import java.lang.annotation.*;

/**
 * 定义一个mongo主键自增的标志注解
 *
 * @author 秋玖壹
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface AutoInc {
}
