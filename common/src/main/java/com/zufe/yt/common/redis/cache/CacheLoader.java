package com.zufe.yt.common.redis.cache;

/**
 * 缓存加载接口,当缓存中没有数据时自动调用load方法并放入缓存
 *
 * @author chengsiyi
 * @date 2022/10/20 15:57
 */
public interface CacheLoader<T> {
    T load();
}
