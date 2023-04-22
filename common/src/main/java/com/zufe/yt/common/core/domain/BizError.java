package com.zufe.yt.common.core.domain;

/**
 * 业务错误码，
 * @author chengsiyi
 * @date 2022/6/15 16:43
 */
public interface BizError {

    default BizError of(String errorCode, String errorMessage) {

        return new BizError() {
            @Override
            public String errorCode() {
                return errorCode;
            }

            @Override
            public String errorMessage() {
                return errorMessage;
            }
        };
    }

    String errorCode();

    String errorMessage();
}
