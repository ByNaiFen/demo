package com.example.employeeadmin.demos.domains.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 职工表
 * </p>
 *
 * @author ysk
 * @since 2023-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

      @TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private String empName;

    /**
     * 性别(code:1002)
     */
    private Integer sex;

    private Integer age;

    /**
     * 部门名称(code:1003)
     */
    @TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private Integer deptName;

    /**
     * 学历(code:1004)
     */
    @TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private Integer empDegreeName;

    /**
     * 激活(code:1001)
     */
    private Integer enabled;

}
