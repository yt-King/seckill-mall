package com.zufe.yt.common.mongo.util;

import java.lang.annotation.*;

/**
 * 默认值
 *
 * @author 秋玖壹
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface InitValue {
    String value();
}
