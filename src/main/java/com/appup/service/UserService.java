package com.appup.service;

import com.appup.controller.Result;
import com.appup.domain.User;
import com.appup.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService  {

    @Resource
    UserMapper userMapper;

    public boolean selectUser(String school, String account) {
        User user = userMapper.selectUser(school, account);
        return user != null && !user.getAccount().isEmpty();

    }


    public boolean insertUser(User user) {
        return userMapper.insertUser(user)>0;
    }
}
