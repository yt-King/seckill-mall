package com.zufe.yt.common.redis.cache;


import com.zufe.yt.common.core.domain.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

/**
 * @author chengsiyi
 * @date 2022/10/20 15:57
 */
public class RedisCacheClient implements AdvancedCacheClient {

    public static final Logger logger = LoggerFactory.getLogger(RedisCacheClient.class);

    private final RedisTemplate redisTemplate;

    private RedisSerializer<String> keyRedisSerializer = new StringRedisSerializer();


    public RedisCacheClient(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public <T> T get(String key) {
        T t = getInner(key);
        //如果取回的数据是NullCache,表示是之前故意放入的,特殊处理,返回null
        if (t != null && t instanceof Null) {
            return null;
        }
        return t;
    }

    @Override
    public boolean set(final String key, final Object value, final int timeout, final TimeUnit unit) {
        if (value == null) {
            return false;
        }

        final byte[] rawKey = rawKey(key);
        final byte[] rawValue = rawValue(value);

        try {
            redisTemplate.execute(new RedisCallback<Object>() {

                @Override
                public Object doInRedis(RedisConnection connection) {

                    potentiallyUsePsetEx(connection);
                    return null;
                }

                public void potentiallyUsePsetEx(RedisConnection connection) {

                    if (!TimeUnit.MILLISECONDS.equals(unit) || !failsafeInvokePsetEx(connection)) {
                        connection.setEx(rawKey, TimeoutUtils.toSeconds(timeout, unit), rawValue);
                    }
                }

                private boolean failsafeInvokePsetEx(RedisConnection connection) {

                    boolean failed = false;
                    try {
                        connection.pSetEx(rawKey, timeout, rawValue);
                    } catch (UnsupportedOperationException e) {
                        // in case the connection does not support pSetEx return false to allow fallback to other operation.
                        failed = true;
                    }
                    return !failed;
                }

            }, true);
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }

        return true;
    }

    private <T> T getInner(String key) {
        final byte[] rawKey = rawKey(key);
        try {
            return (T) redisTemplate.execute((RedisCallback<T>) connection -> {
                byte[] valueBytes = connection.get(rawKey);
                return (T) keyRedisSerializer.deserialize(valueBytes);
            }, true);
        } catch (Exception e) {
            logger.error("get key error:" + key, e);
            return null;
        }
    }

    @Override
    public <T> T getWithCacheLoader(String key, int timeout, TimeUnit timeUnit, boolean isCacheNull, CacheLoader<T> cacheLoader) {
        T value = getInner(key);
        if (value == null) {
            value = cacheLoader.load();
            if (isCacheNull) {
                setWithNull(key, value, timeout, timeUnit);
            } else if (value != null) {
                set(key, value, timeout, timeUnit);
            }
        }

        //如果取回的数据是NullCache,表示是之前故意放入的,特殊处理,返回null
        if (value instanceof Null) {
            value = null;
        }

        return value;
    }

    protected void setWithNull(String key, Object value, int timeout, TimeUnit unit) {
        Object v = value;
        if (v == null) {
            v = Null.NULL;
        }
        set(key, v, timeout, unit);
    }

    @Override
    public <T> T getWithCacheLoader(String key, int exp, TimeUnit timeUnit, CacheLoader<T> cacheLoader) {
        return getWithCacheLoader(key, exp, timeUnit, false, cacheLoader);
    }

    @Override
    public boolean remove(String key) {
        String[] keys = new String[]{key};
        return remove(keys);
    }

    @Override
    public boolean remove(String... keys) {
        final byte[][] rawKeys = new byte[keys.length][];
        int i = 0;
        for (String key : keys) {
            byte[] rawKey = rawKey(key);
            rawKeys[i++] = rawKey;
        }
        try {
            redisTemplate.execute((RedisCallback<Object>) connection -> {
                connection.del(rawKeys);
                return null;
            }, true);
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
        return true;
    }

    private byte[] rawKey(String key) {
        return keyRedisSerializer.serialize(key);
    }

    private byte[] rawValue(Object value) {
        return keyRedisSerializer.serialize(String.valueOf(value));
    }

}
