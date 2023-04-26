package com.zufe.yt.goods.infrastructure.persistence.data;

import com.zufe.yt.common.mongo.util.MongoBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yt
 * @package: com.zufe.yt.goods.infrastructure.persistence.data
 * @className: StockDO
 * @date 2023/4/26
 * @description: 库存持久化对象
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "stock")
public class StockDO extends MongoBaseDO {
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
}
