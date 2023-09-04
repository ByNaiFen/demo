package com.example.employeeadmin.demos.domains.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 码表
 * </p>
 *
 * @author ysk
 * @since 2023-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("code")
public class Code implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private Integer type;

    private String typeName;

    private String typeDesc;


}
