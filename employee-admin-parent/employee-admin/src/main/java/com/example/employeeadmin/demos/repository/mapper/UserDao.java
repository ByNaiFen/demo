package com.example.employeeadmin.demos.repository.mapper;

import com.example.employeeadmin.demos.domains.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ysk
 * @since 2023-09-02
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
