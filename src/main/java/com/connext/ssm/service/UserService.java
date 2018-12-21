package com.connext.ssm.service;

import java.util.Map;

import com.connext.ssm.pojo.User;

public interface UserService {


    /**
     * 登录
     *
     * @param map
     * @return
     */
    User login(Map<String, String> map);

    void regist(User user);

    boolean queryByTelephone(User user);

}