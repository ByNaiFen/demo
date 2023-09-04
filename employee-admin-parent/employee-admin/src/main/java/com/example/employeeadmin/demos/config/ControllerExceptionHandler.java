package com.example.employeeadmin.demos.config;

import com.example.employeeadmin.demos.util.ResponseResult;
import com.example.employeeadmin.demos.web.controller.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice(assignableTypes = UserController.class)
@Slf4j
public class ControllerExceptionHandler {

    /**
     * validation异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<String> paramExceptionHandler(MethodArgumentNotValidException e){
        log.error("参数校验异常",e);
        e.printStackTrace();

        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return new ResponseResult(400,fieldError.getDefaultMessage(),null);
            }
        }

        return new ResponseResult<>(400, "参数校验错误", null);
    }

   
    /**
     * 参数适配异常,捕获mvc的参数适配异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult<String> formDataExceptionHandler(RuntimeException e){
        e.printStackTrace();
        return new ResponseResult<>(400, e.getMessage(),null);
    }

}