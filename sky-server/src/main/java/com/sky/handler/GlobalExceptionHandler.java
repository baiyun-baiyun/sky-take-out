package com.sky.handler;

import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice//声明这是一个全局异常处理类
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler//这个注解用在方法上，表示该方法专门用来处理某种类型的异常。
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
        //在代码中，exceptionHandler(BaseException ex) 方法专门捕获 BaseException 类型的异常。这意味着，只要项目中任何地方抛出了 BaseException（或者其子类），都会被这个方法拦截。
    }

}
