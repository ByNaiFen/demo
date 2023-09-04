package com.example.employeeadmin.demos.domains.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YeShaoKang
 * @date 2023/9/4 14:55
 */
@Data
public class EmployeePageVo {

    @TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private String empName;

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
    @TableLogic("10011001")
    private Integer enabled;

    private Long pageSize;
    private Long pageNum;

    public EmployeePageVo() {
        this.pageNum = 1L; // 设置page的默认值为1
        this.pageSize = 10L; // 设置pageSize的默认值为10
    }
}
