package com.zufe.yt.order.interfaces.dto;

import com.zufe.yt.order.domain.order.entity.ChildOrder;
import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.order.interfaces.dto
 * @className: OrderDTO
 * @date 2023/4/24
 * @description: 订单dto
 */

@Data
public class OrderDTO {
    String id;
    /**
     * 用户id
     */
    String userId;
    /**
     * 子订单
     */
    List<ChildOrderDTO> childOrders;
    /**
     * 创建时间
     */
    Double createTime;
}
