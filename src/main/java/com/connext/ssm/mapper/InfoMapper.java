package com.connext.ssm.mapper;

import java.util.List;

import com.connext.ssm.pojo.Info;

public interface InfoMapper {
    public void delete(Integer id);
    public List<Info> queryAll();
    public Info queryById(Integer id);
    public void updateById(Info info);
}
