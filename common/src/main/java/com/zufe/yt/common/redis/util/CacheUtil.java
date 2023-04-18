package com.zufe.yt.common.redis.util;


import com.alibaba.fastjson.JSON;
import com.zufe.yt.common.core.exception.ServiceException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 秋玖壹
 **/
@Component
public class CacheUtil {
    private static RedisService redisService;
    private static RedissonClient redissonClient;
    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisService(RedisService redisService) {
        CacheUtil.redisService = redisService;
    }

    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        CacheUtil.redissonClient = redissonClient;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        CacheUtil.redisTemplate = redisTemplate;
    }

    /**
     * 判断缓存是否有数据 没有数据则插入
     *
     * @param key      缓存主键
     * @param ms       过期时间（毫秒）
     * @param listener 回调
     */
    @Deprecated
    public static void setIfAbsent(String key, long ms, CacheCallListener listener) {
        if (redisService.getExpire(key) <= 300) {
            RLock lock = redissonClient.getLock("LOCK:" + key);

            try {
                lock.lock(ms, TimeUnit.MILLISECONDS);

                if (redisService.getExpire(key) <= 2) {
                    listener.queryDb();
                }
                if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServiceException(e.getMessage());
            } finally {
                if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * 如果key存在，对key续期；不存在就存入
     *
     * @param key         缓存主键
     * @param second      续期时间（秒）
     * @param callback    查询回调
     * @param isHashValue 是否值是hash
     */
    public static void renewOrSet(String key, long second, QueryCallback callback, boolean isHashValue) {
        String secondStr = second + "";

        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/renew.lua")));
        redisScript.setResultType(Long.class);
        Long result = redisTemplate.execute(redisScript, Collections.singletonList(key), secondStr);
        if (result != null && result == -1) {
            String value = JSON.toJSONString(callback.query());
            if (isHashValue) {
                // lua脚本不支持键值对 只能将过期时间和键值对存入数组一起传入
                List<String> data = new ArrayList<>();
                data.add(secondStr);
                for (Map.Entry<String, Object> entry : JSON.parseObject(value).entrySet()) {
                    data.add(entry.getKey());
                    data.add(entry.getValue() + "");
                }
                redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/storeHashSafe.lua")));
                redisTemplate.execute(redisScript, Collections.singletonList(key), data.toArray());
            } else {
                redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/storeSafe.lua")));
                redisTemplate.execute(redisScript, Collections.singletonList(key), value, secondStr);
            }
        }
    }

    @Deprecated
    public interface CacheCallListener {
        /**
         * 如果不存在就去查询数据库
         */
        void queryDb();
    }

    public interface QueryCallback {
        /**
         * 如果不存在就去查询数据库
         *
         * @return 结果
         */
        Object query();
    }
}
