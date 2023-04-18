package com.zufe.yt.common.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * redis服务
 *
 * @author haoxin
 * @date 2021-06-07
 **/
@Slf4j
public class RedisService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key               键
     * @param expireSecondsTime 时间(秒)
     * @return Boolean
     */
    public void expire(String key, Long expireSecondsTime) {
        if (expireSecondsTime > 0) {
            redisTemplate.expire(key, expireSecondsTime, TimeUnit.SECONDS);
        }
    }

    /**
     * 根据key获取过期时间
     *
     * @param key 键 不能为 null
     * @return 时间(秒) 返回 0代表为永久有效
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断 key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public Boolean hasKey(String key) {

        return redisTemplate.hasKey(key);
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(Arrays.asList(key));
            }
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key               键
     * @param value             值
     * @param expireSecondsTime 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     */
    public void set(String key, Object value, Long expireSecondsTime) {
        if (expireSecondsTime > 0) {
            redisTemplate.opsForValue().set(key, value, expireSecondsTime, TimeUnit.SECONDS);
        } else {
            set(key, value);
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return Long
     */
    public Long incr(String key, Long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几
     * @return Long
     */
    public Long decr(String key, Long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * HashGet
     *
     * @param key  键 不能为 null
     * @param item 项 不能为 null
     * @return 值
     */
    public Object hGet(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取 hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     */
    public void hmSet(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * HashSet 并设置时间
     *
     * @param key               键
     * @param map               对应多个键值
     * @param expireSecondsTime 时间(秒)
     */
    public void hmSet(String key, Map<String, Object> map, Long expireSecondsTime) {
        redisTemplate.opsForHash().putAll(key, map);
        if (expireSecondsTime > 0) {
            expire(key, expireSecondsTime);
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     */
    public void hSet(String key, String item, Object value) {
        redisTemplate.opsForHash().put(key, item, value);
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key               键
     * @param item              项
     * @param value             值
     * @param expireSecondsTime 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     */
    public void hSet(String key, String item, Object value, Long expireSecondsTime) {
        redisTemplate.opsForHash().put(key, item, value);
        if (expireSecondsTime > 0) {
            expire(key, expireSecondsTime);
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为 null
     * @param item 项 可以使多个不能为 null
     */
    public void hDel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为 null
     * @param item 项 不能为 null
     * @return true 存在 false不存在
     */
    public Boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return Double
     */
    public Double hIncr(String key, String item, Double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return Double
     */
    public Double hDecr(String key, String item, Double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /**
     * hash 根据指定key和hasKey集合获取数据
     *
     * @param key     键
     * @param hasKeys hash键集合
     */
    public List<Object> hMultiGet(String key, Collection<Object> hasKeys) {
        return redisTemplate.opsForHash().multiGet(key, hasKeys);
    }

    /**
     * 根据 key获取 Set中的所有值
     *
     * @param key 键
     * @return Set
     */
    public Set<Object> sGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public Boolean sHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public Long sSet(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 将set数据放入缓存
     *
     * @param key               键
     * @param expireSecondsTime 时间(秒)
     * @param values            值 可以是多个
     * @return 成功个数
     */
    public Long sSetAndTime(String key, Long expireSecondsTime, Object... values) {
        Long count = redisTemplate.opsForSet().add(key, values);
        if (expireSecondsTime > 0) {
            expire(key, expireSecondsTime);
        }
        return count;
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return Long
     */
    public Long sGetSetSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public Long setRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    public void zsSet(String key, Object value, double source) {
        redisTemplate.opsForZSet().add(key, value, source);
    }

    public void zsSetMulti(String key, Set<ZSetOperations.TypedTuple<Object>> values) {
        redisTemplate.opsForZSet().add(key, values);
    }

    public void zsDel(String key, Object... value) {
        redisTemplate.opsForZSet().remove(key, value);
    }

    public List<Object> zsPage(String key, long page, long pageSize, boolean isDesc) {
        Long size = redisTemplate.opsForZSet().size(key);
        List<Object> list = new ArrayList<>();
        if (size != null && size > 0) {
            if (isDesc) {
                list.add(redisTemplate.opsForZSet().reverseRange(key, (page - 1) * pageSize, page * pageSize - 1));
            } else {
                list.add(redisTemplate.opsForZSet().range(key, (page - 1) * pageSize, page * pageSize - 1));
            }
        }

        return list;
    }

    public Set<Object> zsAll(String key, boolean isDesc) {
        Long size = redisTemplate.opsForZSet().size(key);
        if (size == null || size <= 0) {
            return Collections.emptySet();
        }
        if (isDesc) {
            return redisTemplate.opsForZSet().reverseRange(key, 0, size);
        } else {
            return redisTemplate.opsForZSet().range(key, 0, size);
        }
    }

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return List
     */
    public List<Object> lGet(String key, Long start, Long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return Long
     */
    public Long lGetListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；
     *              index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return Object
     */
    public Object lGetIndex(String key, Long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return Boolean
     */
    public void lSet(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 将list放入缓存
     *
     * @param key               键
     * @param value             值
     * @param expireSecondsTime 时间(秒)
     * @return Boolean
     */
    public void lSet(String key, Object value, Long expireSecondsTime) {
        redisTemplate.opsForList().rightPush(key, value);
        if (expireSecondsTime > 0) {
            expire(key, expireSecondsTime);
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     */
    public void lSet(String key, List<Object> value) {
        redisTemplate.opsForList().rightPushAll(key, value);
    }

    /**
     * 将list放入缓存
     *
     * @param key               键
     * @param value             值
     * @param expireSecondsTime 时间(秒)
     */
    public void lSet(String key, List<Object> value, Long expireSecondsTime) {
        redisTemplate.opsForList().rightPushAll(key, value);
        if (expireSecondsTime > 0) {
            expire(key, expireSecondsTime);
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return Boolean
     */
    public void lUpdateIndex(String key, Long index, Object value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public Long lRemove(String key, Long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }

    public Boolean lock(String key, Long expireSecondsTime) {
        return redisTemplate.opsForValue().setIfAbsent(key, System.currentTimeMillis() + "", expireSecondsTime, TimeUnit.SECONDS);
    }

    /**
     * 发送通知
     *
     * @param channel 渠道
     * @param value   值
     */
    public void convertAndSend(String channel, Object value) {
        redisTemplate.convertAndSend(channel, value);
    }

}
