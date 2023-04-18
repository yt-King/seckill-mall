package com.zufe.yt.common.redis.util;


import com.zufe.yt.common.core.exception.ServiceException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 秋玖壹
 */
@Component
public class LockUtil {
    private static RedissonClient redissonClient;

    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        LockUtil.redissonClient = redissonClient;
    }

    public static void lock(String key, int ms, LockCall call) {
        RLock lock = redissonClient.getLock(key);
        try {
            lock.lock(ms, TimeUnit.MILLISECONDS);

            call.call();

            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                throw new ServiceException(e.getMessage(), ((ServiceException) e).getCode());
            } else {
                e.printStackTrace();
                throw new ServiceException(e.getMessage());
            }
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public interface LockCall {
        /**
         * 执行任务
         */
        void call();
    }
}
