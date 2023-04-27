package com.zufe.yt.common.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回数据定义
 *
 * @author 秋玖壹
 **/
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * success
     */
    SUCCESS(0, "success"),
    /**
     * 库存不足
     */
    STOCK_INSUFFICIENT(233, "库存不足"),
    /**
     * 系统异常
     */
    FAILURE(500, "系统异常");

    private final int code;

    private final String msg;
}
