package com.example.employeeadmin.demos.domains.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ysk
 * @since 2023-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotBlank(message="用户名不能为空")
    private String username;
    @NotBlank(message="密码不能为空")
    private String password;

    /**
     * 激活(code:1001)
     */
    @TableLogic("10011001")
    private Integer enabled;


}
