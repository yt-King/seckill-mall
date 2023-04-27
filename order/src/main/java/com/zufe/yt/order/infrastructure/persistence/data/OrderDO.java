package com.zufe.yt.order.infrastructure.persistence.data;

import com.zufe.yt.common.mongo.util.MongoBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.order.infrastructure.persistence.data
 * @className: OrderDO
 * @date 2023/4/24
 * @description: 订单持久化对象
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "order")
public class OrderDO extends MongoBaseDO {
    /**
     * 用户id
     */
    String userId;
    /**
     * 子订单
     */
    List<ChildOrderDO> childOrders;
}
