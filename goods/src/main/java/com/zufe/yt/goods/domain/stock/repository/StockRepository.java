package com.zufe.yt.goods.domain.stock.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.goods.domain.stock.entity.Stock;
import com.zufe.yt.goods.infrastructure.persistence.data.StockDO;

/**
 * @author yt
 * @date 2023/4/26
 * @description: TODO
 */
public interface StockRepository extends IRepository<Stock, StockDO> {
    /**
     * 新增库存
     *
     * @param stock 库存
     */
    void save(Stock stock);

    /**
     * 根据商品ID查库存
     *
     * @param productId 商品ID
     * @return 库存
     */
    Stock findById(String productId);

    /**
     * 设置总量
     *
     * @param productId 商品ID
     * @param total    限制数量
     */
    void setTotalCount(String productId, Integer total);

    /**
     * 扣除库存
     *
     * @param incCount 操作数
     * @param stock    库存类
     */
    Long incGotCount(Integer incCount, Stock stock);
}
