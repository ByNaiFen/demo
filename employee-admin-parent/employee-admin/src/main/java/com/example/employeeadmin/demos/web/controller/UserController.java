package com.example.employeeadmin.demos.web.controller;

import com.example.employeeadmin.demos.domains.po.Code;
import com.example.employeeadmin.demos.domains.po.User;
import com.example.employeeadmin.demos.service.CodeService;
import com.example.employeeadmin.demos.service.UserService;
import com.example.employeeadmin.demos.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author YeShaoKang
 * @date 2023/9/2 23:13
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "用户管理API")
public class UserController {
    private final UserService userService;
    private final CodeService codeService;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    @Operation( summary = "用户登录", description = "用户登录", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功登录")
    })
    public ResponseResult login(@Valid @RequestBody @Parameter(description = "用户信息", required = true) User user){
        userService.lambdaQuery().eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, user.getPassword())
                .oneOpt()
                .orElseThrow(() -> new RuntimeException("用户名或者密码错误!"));

        return new ResponseResult<>(200, "登录成功", null);
    }

    @GetMapping("/code/{type}")
    public List<Code> getCodeByType(@PathVariable("type") Integer type){
        return codeService.lambdaQuery().eq(Code::getType, type)
                .list();
    }

    @GetMapping("/code/id/{id}")
    public Code getCodeById(@PathVariable("id") Integer id){
        return codeService.lambdaQuery().eq(Code::getId, id)
                .one();
    }
}
