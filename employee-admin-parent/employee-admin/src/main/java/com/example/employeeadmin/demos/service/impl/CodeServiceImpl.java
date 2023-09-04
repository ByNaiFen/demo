package com.example.employeeadmin.demos.service.impl;

import com.example.employeeadmin.demos.domains.po.Code;
import com.example.employeeadmin.demos.repository.mapper.CodeDao;
import com.example.employeeadmin.demos.service.CodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 码表 服务实现类
 * </p>
 *
 * @author ysk
 * @since 2023-09-04
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeDao, Code> implements CodeService {

}
