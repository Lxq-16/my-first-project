package com.club.common.exception;

import com.club.common.result.Result;
import com.club.common.result.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 自定义业务异常
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result<?> businessException(BusinessException e){
        return Result.fail(e.getCode(), e.getMessage());
    }

    // 表单/JSON参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<?> validException(MethodArgumentNotValidException e){
        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.fail(ResultCode.FAIL, msg);
    }

    // 新增：捕获GET/POST请求方式不匹配报错（解决控制台大量红色堆栈）
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result<?> methodNotSupportException(HttpRequestMethodNotSupportedException e){
        return Result.fail(ResultCode.FAIL, "请求方式错误：该接口仅支持POST，禁止浏览器地址栏GET访问");
    }

    // 全局兜底未知异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> globalException(Exception e){
        e.printStackTrace();
        return Result.fail(ResultCode.FAIL, "系统异常："+e.getMessage());
    }
}