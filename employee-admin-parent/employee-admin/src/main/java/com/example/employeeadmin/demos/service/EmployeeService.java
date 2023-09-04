package com.example.employeeadmin.demos.service;

import com.example.employeeadmin.demos.domains.dto.EmployeeDto;
import com.example.employeeadmin.demos.domains.po.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.employeeadmin.demos.domains.vo.EmployeePageVo;

import java.util.List;

/**
 * <p>
 * 职工表 服务类
 * </p>
 *
 * @author ysk
 * @since 2023-09-02
 */
public interface EmployeeService extends IService<Employee> {

    void add(Employee employee);

    void deleteById(Integer id);

    void modify(Employee employee);

    List<EmployeeDto> queryExportData(Employee employee);
}
