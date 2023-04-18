package com.zufe.yt.common.redis.cache;

import org.springframework.data.redis.core.RedisTemplate;

import java.beans.PropertyEditorSupport;


/**
 * 这个类负责把RedisTemplate 转换成 RedisCacheClient。
 * <p>
 * spring会自动找到这个类（*Editor）,spring的Editor机制
 *
 * @author chengsiyi
 * @date 2022/10/20 15:57
 */
public class AdvancedCacheClientEditor extends PropertyEditorSupport {

    @Override
    public void setValue(Object value) {
        if (value instanceof RedisTemplate) {
            AdvancedCacheClient advancedCacheClient = new RedisCacheClient((RedisTemplate) value);
            super.setValue(advancedCacheClient);
        } else {
            throw new IllegalArgumentException("Editor supports only conversion of type " + RedisTemplate.class);
        }
    }
}
