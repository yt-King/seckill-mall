package com.zufe.yt.common.core.domain;


/**
 * @author chengsiyi
 * @date 2022/6/15 16:56
 */
public class BizRuntimeException extends RuntimeException {

    private String code = "000000";

    /**
     * 是否需要warn级别日志输出
     */
    private boolean outWarnLog = true;

    public BizRuntimeException(String message) {
        super(message);
    }

    public BizRuntimeException(String message, boolean outWarnLog) {
        super(message);
        this.outWarnLog = outWarnLog;
    }

    public BizRuntimeException(BizError bizError) {
        super(bizError.errorMessage());
        this.code = bizError.errorCode();
    }

    public BizRuntimeException(BizError bizError, boolean outWarnLog) {
        super(bizError.errorMessage());
        this.code = bizError.errorCode();
        this.outWarnLog = outWarnLog;
    }

    public BizRuntimeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizRuntimeException(String code, String message, boolean outWarnLog) {
        super(message);
        this.code = code;
        this.outWarnLog = outWarnLog;
    }

    public BizRuntimeException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BizRuntimeException(String code, String message, Throwable cause, boolean outWarnLog) {
        super(message, cause);
        this.code = code;
        this.outWarnLog = outWarnLog;
    }

    public BizRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizRuntimeException(String message, Throwable cause, boolean outWarnLog) {
        super(message, cause);
        this.outWarnLog = outWarnLog;
    }

    public BizRuntimeException(Throwable cause) {
        super(cause);
    }

    public BizRuntimeException(Throwable cause, boolean outWarnLog) {
        super(cause);
        this.outWarnLog = outWarnLog;
    }

    public String getCode() {
        return code;
    }

    public boolean isOutWarnLog() {
        return outWarnLog;
    }

}
