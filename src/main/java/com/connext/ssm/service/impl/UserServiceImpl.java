package com.connext.ssm.service.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.connext.ssm.controller.MD5Utils;
import com.connext.ssm.mapper.UserMapper;
import com.connext.ssm.pojo.User;
import com.connext.ssm.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User login(Map<String, String> map) {
        // TODO Auto-generated method stub
        return userMapper.login(map);
    }

    @Override
    public void regist(User user) {
        // TODO Auto-generated method stub
        String password = MD5Utils.encode(user.getPassword());
        userMapper.addUser(user.getTelephone(), password);
    }

    @Override
    public boolean queryByTelephone(User user) {
        if(userMapper.queryByTelephone(user)!= null){
            return true;
        }else{
            return false;
        }

    }

}