package com.example.employeeadmin.demos.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dongxiaohao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private Integer status;
    private String msg;
    private T data;

    public static ResponseResult error(ResultCode resultCode){
        ResponseResult result = new ResponseResult();
        result.setStatus(resultCode.getCode());
        result.setMsg(resultCode.getMessage());
        return result;
    }
}
