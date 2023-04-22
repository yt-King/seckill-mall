package com.zufe.yt.common.redis.cache;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsiyi
 * @date 2022/10/20 15:57
 */
public interface AdvancedCacheClient {

    <T> T get(String key);

    /**
     * 设置值,如果value为null不会放入缓存
     *
     * @param key      key
     * @param value    value
     * @param exp      失效时间
     * @param timeUnit 时间单位
     * @return 结果
     */
    boolean set(String key, Object value, int exp, TimeUnit timeUnit);

    /**
     * 根据Key读取Cache中的值,当值为null时会自动调用cacheLoader.load方法获得值并set进缓存
     *
     * @param key         key
     * @param exp         失效时间
     * @param timeUnit    时间单位
     * @param isCacheNull isCacheNull为true时, 如果cacheLoader.load得到null,则会把NullCache.NULL放入缓存,以减少对数据库的穿透,get时会判断如果是NullCache实例则直接返回null
     * @param cacheLoader 数据加载器
     * @return 结果
     */
    <T> T getWithCacheLoader(String key, int exp, TimeUnit timeUnit, boolean isCacheNull, CacheLoader<T> cacheLoader);

    /**
     * 根据Key读取Cache中的值,当值为null时会自动调用cacheLoader.load方法获得值并set进缓存
     *
     * @param key         key
     * @param exp         失效时间
     * @param timeUnit    时间单位
     * @param cacheLoader 数据加载器
     * @return 结果
     */
    <T> T getWithCacheLoader(String key, int exp, TimeUnit timeUnit, CacheLoader<T> cacheLoader);

    /**
     * 移除key
     *
     * @param key key
     * @return 结果
     */
    boolean remove(String key);

    /**
     * 移除多个key
     *
     * @param keys keys
     * @return 结果
     */
    boolean remove(String... keys);
}
