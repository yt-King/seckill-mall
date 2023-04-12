package com.zufe.yt.common.core.exception;

/**
 * 公用的自定义异常
 *
 * @author 秋玖壹
 **/
public class ServiceException extends RuntimeException {
    private String msg;

    private int code;

    public ServiceException(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public ServiceException(String msg) {
        this.msg = msg;
        this.code = 500;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return msg == null ? "发送未知错误" : msg;
    }

    public int getCode() {
        return code;
    }
}
