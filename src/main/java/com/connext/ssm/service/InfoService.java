package com.connext.ssm.service;

import java.util.List;

import com.connext.ssm.pojo.Info;

public interface InfoService {
    public void delete(Integer id);
    public List<Info> queryAll();
    public Info queryById(Integer id);
    public void updateById(Info info);


}