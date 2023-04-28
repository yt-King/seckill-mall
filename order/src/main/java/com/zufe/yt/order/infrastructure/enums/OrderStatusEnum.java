package com.zufe.yt.order.infrastructure.enums;

/**
 * @author yt
 * @date 2023/4/27
 */

public enum OrderStatusEnum {
    /**
     * 成功
     */
    SUCCESS,
    /**
     * 库存不足
     */
    STOCK_INSUFFICIENT,
    /**
     * 其他失败
     */
    OTHER_FAILURE,
    /**
     * 未知异常
     */
    UNKNOWN
}
