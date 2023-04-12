package com.zufe.yt.common.core.constant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 秋玖壹
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public String toJson() {
        return this.data == null ? JSON.toJSONString(this) : this.toJson(SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue);
    }

    public String toJson(SerializerFeature... features) {
        return features == null ? this.toJson() : JSON.toJSONString(this, features);
    }

    public static <T> Result<T> builder(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMsg(), null);
    }

    public static <T> Result<T> builder(ResultCode resultCode, T data) {
        return new Result<>(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static <T> Result<T> builder(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> success(T data) {
        return builder(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> success() {
        return builder(ResultCode.SUCCESS);
    }

    public static <T> Result<T> failure() {
        return builder(ResultCode.FAILURE, null);
    }

    public static <T> Result<T> failure(T date) {
        return builder(ResultCode.FAILURE, date);
    }

    public static <T> Result<T> failureMsg(String msg) {
        return builder(ResultCode.FAILURE.getCode(), msg, null);
    }
}
