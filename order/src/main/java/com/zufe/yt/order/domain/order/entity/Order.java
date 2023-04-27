package com.zufe.yt.order.domain.order.entity;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.order.domain.order.entity
 * @className: order
 * @date 2023/4/24
 * @description: 订单实体类
 */

@Data
public class Order {
    String id;
    /**
     * 用户id
     */
    String userId;
    /**
     * 子订单
     */
    List<ChildOrder> childOrders;
    /**
     * 创建时间
     */
    Double createTime;

    public void valid() {
        if (StrUtil.isBlank(this.userId)) {
            throw new ServiceException("用户id不能为空", 100001);
        }
        if (childOrders.isEmpty()) {
            throw new ServiceException("子订单不能为空", 100001);
        }
    }
}
