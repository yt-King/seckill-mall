package com.zufe.yt.person.domain.order.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.domain.person.entity.value
 * @className: order
 * @date 2023/4/11
 * @description: 用户订单实体
 */

@Data
public class Order {
    private String id;
    private String userId;
    private List<String> orderIds;
}
