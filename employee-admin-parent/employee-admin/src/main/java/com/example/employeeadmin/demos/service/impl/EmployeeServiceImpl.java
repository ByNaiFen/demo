package com.example.employeeadmin.demos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.employeeadmin.demos.domains.dto.EmployeeDto;
import com.example.employeeadmin.demos.domains.po.Employee;
import com.example.employeeadmin.demos.domains.vo.EmployeePageVo;
import com.example.employeeadmin.demos.repository.mapper.EmployeeDao;
import com.example.employeeadmin.demos.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 职工表 服务实现类
 * </p>
 *
 * @author ysk
 * @since 2023-09-02
 */
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Override
    public void add(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void modify(Employee employee) {
        employeeDao.updateById(employee);
    }

    @Override
    public List<EmployeeDto> queryExportData(Employee employee) {
        return employeeDao.queryExportData(employee);
    }
}
