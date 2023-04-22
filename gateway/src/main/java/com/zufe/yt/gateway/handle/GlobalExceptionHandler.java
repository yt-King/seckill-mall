package com.zufe.yt.gateway.handle;

import com.alibaba.fastjson.JSONObject;
import com.zufe.yt.common.core.constant.Result;
import com.zufe.yt.common.core.constant.ResultCode;
import com.zufe.yt.gateway.util.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

/**
 * 全局异常处理
 *
 * @author 秋玖壹
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private Result<Object> builder(int code, String msg, Exception exception) {
        JSONObject object = new JSONObject();
        // 堆栈信息
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        exception.printStackTrace(new PrintStream(byteArrayOutputStream));
        object.put("stack", byteArrayOutputStream.toString());

        // 文件信息
        StackTraceElement[] stackTrace = exception.getStackTrace();
        String fullClassName = stackTrace[0].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = stackTrace[0].getMethodName();
        int lineNumber = stackTrace[0].getLineNumber();
        object.put("file", className + "." + methodName + "(" + className + ".java:" + lineNumber + ")");

        return Result.builder(code, msg, object);
    }

    @ExceptionHandler(SQLException.class)
    public Result<Object> sqlException(HttpServletRequest request, Exception exception) {
        this.log(request, exception);
        return this.builder(ResultCode.FAILURE.getCode(), exception.getMessage(), exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> validException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        this.log(request, exception);
        String msg = exception.getFieldError().getDefaultMessage() + "，属性[" + exception.getFieldError().getField() + "]";
        return this.builder(ResultCode.FAILURE.getCode(), msg, exception);
    }

    @ExceptionHandler(Exception.class)
    public Result<Object> serverError(HttpServletRequest request, Exception exception) {
        this.log(request, exception);
        return this.builder(ResultCode.FAILURE.getCode(), exception.getMessage(), exception);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<Object> notFound(HttpServletRequest request, NoHandlerFoundException exception) {
        this.log(request, exception);
        return this.builder(404, "找不到地址 " + exception.getRequestURL(), exception);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Object> paramException(HttpServletRequest request, MissingServletRequestParameterException exception) {
        this.log(request, exception);
        return this.builder(ResultCode.FAILURE.getCode(), "缺少参数:" + exception.getParameterName(), exception);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public Result<Object> requestTypeMismatch(HttpServletRequest request, TypeMismatchException exception) {
        this.log(request, exception);
        return this.builder(ResultCode.FAILURE.getCode(), "参数类型不匹配,参数" + exception.getPropertyName() + "类型应该为" + exception.getRequiredType(), exception);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> requestMethod(HttpServletRequest request, HttpRequestMethodNotSupportedException exception) {
        this.log(request, exception);
        return this.builder(ResultCode.FAILURE.getCode(), "请求方式有误，请改为：" + exception.getMethod(), exception);
    }

    @ExceptionHandler(MultipartException.class)
    public Result<Object> fileSizeLimit(HttpServletRequest request, MultipartException exception) {
        this.log(request, exception);
        return this.builder(ResultCode.FAILURE.getCode(), "超过文件大小限制", exception);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<Object> handleException(HttpServletRequest request, IllegalArgumentException exception){
        this.log(request, exception);
        return this.builder(ResultCode.FAILURE.getCode(), exception.getMessage(), exception);
    }

    private void log(HttpServletRequest request, Exception exception) {
        log.error("请求地址:{} 来自IP：{} 报错内容:{}", request.getRequestURI(), IpUtils.getIpAddr(request), exception);
    }
}
