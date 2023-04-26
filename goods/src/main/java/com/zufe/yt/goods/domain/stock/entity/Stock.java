package com.zufe.yt.goods.domain.stock.entity;

import com.zufe.yt.goods.domain.stock.value.ProductId;
import com.zufe.yt.goods.domain.stock.value.GotCount;
import com.zufe.yt.goods.domain.stock.value.TotalCount;
import lombok.Builder;
import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.goods.domain.stock.entity
 * @className: Stock
 * @date 2023/4/26
 * @description: 商品库存实体类
 */

@Data
@Builder
public class Stock {
    private String id;
    /**
     * 商品id
     */
    private ProductId productId;
    /**
     * 商品总量
     */
    private TotalCount totalCount;
    /**
     * 商品已购买量
     */
    private GotCount gotCount;
}
