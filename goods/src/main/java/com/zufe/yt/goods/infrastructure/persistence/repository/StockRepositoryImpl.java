package com.zufe.yt.goods.infrastructure.persistence.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.common.redis.util.RedisService;
import com.zufe.yt.goods.domain.stock.entity.Stock;
import com.zufe.yt.goods.domain.stock.repository.StockRepository;
import com.zufe.yt.goods.infrastructure.persistence.data.StockDO;
import com.zufe.yt.goods.infrastructure.transfer.StockMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yt
 * @package: com.zufe.yt.goods.infrastructure.persistence.repository
 * @className: StockRepositoryImpl
 * @date 2023/4/26
 * @description: 库存持久化实现
 */

@Repository
public class StockRepositoryImpl extends RepositoryImpl<Stock, StockDO> implements StockRepository {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private RedisService redisService;
    @Resource(name = "limitScript")
    private DefaultRedisScript<Long> limitScript;
    @Resource(name = "storeScript")
    private DefaultRedisScript<Long> storeScript;
    private static final String STOCK_KEY = "CACHE_STOCK_KEY:%s";

    @Override
    public void save(Stock stock) {
        StockDO stockDO = StockMapper.INSTANCE.toDO(stock);
        mongoUtil.insertOrUpdate(stockDO);
    }

    @Override
    public Stock findById(String productId) {
        String key = String.format(STOCK_KEY, productId);
        Object find = redisService.get(key);
        if (find == null) {
            Stock stock = super.find(new CriteriaAndWrapper().eq(Stock::getProductId, productId));
            if (stock != null) {
                this.store(key, JSON.parseObject(JSON.toJSONString(StockMapper.INSTANCE.toDO(stock))), false);
                return stock;
            }
            return null;
        }
        return StockMapper.INSTANCE.toEntity(find);
    }

    @Override
    public void setTotalCount(String productId, Integer total) {
        String key = String.format(STOCK_KEY, productId);

        JSONObject object = new JSONObject();
        object.put("totalCount", total);
        this.store(key, object, true);
    }

    @Override
    public Long incGotCount(Integer incCount, Stock stock) {
        String key = String.format(STOCK_KEY, stock.getProductId());
        return redisTemplate.execute(limitScript, new StringRedisSerializer(),
                new Jackson2JsonRedisSerializer<>(Long.class), Collections.singletonList(key),
                Arrays.asList("totalCount", incCount + "", stock.getTotalCount() + "").toArray());
    }

    private void store(String key, JSONObject jsonObject, boolean isUpdate) {
        List<String> args = new ArrayList<>();
        args.add(isUpdate ? "1" : "0");
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            args.add(entry.getKey());
            args.add(entry.getValue() + "");
        }
        redisTemplate.execute(storeScript, new StringRedisSerializer(),
                new Jackson2JsonRedisSerializer<>(Long.class), Collections.singletonList(key), args.toArray());
    }
}
