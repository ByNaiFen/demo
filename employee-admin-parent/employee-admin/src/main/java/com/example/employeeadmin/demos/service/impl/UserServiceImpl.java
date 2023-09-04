package com.example.employeeadmin.demos.service.impl;

import com.example.employeeadmin.demos.domains.po.User;
import com.example.employeeadmin.demos.repository.mapper.UserDao;
import com.example.employeeadmin.demos.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.employeeadmin.demos.util.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ysk
 * @since 2023-09-02
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
