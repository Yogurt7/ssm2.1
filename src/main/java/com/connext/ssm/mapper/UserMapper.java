package com.connext.ssm.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.connext.ssm.pojo.User;

public interface UserMapper {


    /**
     * 登录
     *
     * @param map
     * @return
     */
    User login(Map<String, String> map);

    void addUser(@Param("telephone") String telephone,
                 @Param("password") String password);
    User queryByTelephone(User user);

}