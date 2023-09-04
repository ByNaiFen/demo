package com.example.employeeadmin.demos.domains.dto;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author YeShaoKang
 * @date 2023/9/5 1:17
 */
@Data
public class EmployeeDto {

    private String empName;

    private String sex;

    private Integer age;

    private String deptName;

    private String empDegreeName;
}
