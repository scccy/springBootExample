package com.scccy.springbootexample01.handlerExption;


import com.scccy.springbootexample01.common.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {





    // 处理所有未被前面特定异常处理器捕获的异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultData> handleGlobalException(Exception ex, WebRequest request) {
        // 通常是未预料的错误，返回一个INTERNAL_SERVER_ERROR(500)响应
        // 同时建议隐藏具体的错误细节，以免泄露敏感信息
        return new ResponseEntity<>(ResultData.fail().setMsg("An unexpected error occurred, please contact support.")
                .setData("Error details are hidden for security."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 自定义的异常类
    public static class CustomException extends RuntimeException {
        public CustomException(String message) {
            super(message);
        }
    }
}