package com.example.demo.infra.user.service.impl;

import com.example.demo.infra.user.entity.User;
import com.example.demo.infra.user.mapper.UserMapper;
import com.example.demo.infra.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
