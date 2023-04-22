package com.zufe.yt.common.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不是登录状态也能访问的地址
 * @author chengsiyi
 * @date 2022/6/10 11:39
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoLoginCanAccess {
}
