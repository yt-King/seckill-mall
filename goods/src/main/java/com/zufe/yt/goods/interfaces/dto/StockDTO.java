package com.zufe.yt.goods.interfaces.dto;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.goods.interfaces.dto
 * @className: StockDTO
 * @date 2023/4/26
 * @description: 库存持久化对象
 */

@Data
public class StockDTO {
    String id;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品总量
     */
    private Integer totalCount;
    /**
     * 商品已购买量
     */
    private Integer gotCount;
    /**
     * 操作数量
     */
    private Integer incCount;
    /**
     * 幂等id
     */
    private String uuid;
}
