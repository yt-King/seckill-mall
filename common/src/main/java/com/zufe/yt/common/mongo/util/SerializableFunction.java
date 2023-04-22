package com.zufe.yt.common.mongo.util;

import java.io.Serializable;
import java.util.function.Function;

/**
 * 序列化
 *
 * @author 秋玖壹
 */
@FunctionalInterface
public interface SerializableFunction<T, R> extends Function<T, R>, Serializable {

}
