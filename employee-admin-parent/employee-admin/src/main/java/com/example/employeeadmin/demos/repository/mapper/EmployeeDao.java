package com.example.employeeadmin.demos.repository.mapper;

import com.example.employeeadmin.demos.domains.dto.EmployeeDto;
import com.example.employeeadmin.demos.domains.po.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.employeeadmin.demos.domains.vo.EmployeePageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 职工表 Mapper 接口
 * </p>
 *
 * @author ysk
 * @since 2023-09-02
 */
@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {


    List<EmployeeDto> queryExportData(Employee employee);
}
