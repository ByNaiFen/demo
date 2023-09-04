package com.example.employeeadmin.demos.repository.mapper;

import com.example.employeeadmin.demos.domains.po.Code;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 码表 Mapper 接口
 * </p>
 *
 * @author ysk
 * @since 2023-09-04
 */
@Mapper
public interface CodeDao extends BaseMapper<Code> {

}
