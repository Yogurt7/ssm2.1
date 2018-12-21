package com.connext.ssm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connext.ssm.mapper.InfoMapper;
import com.connext.ssm.pojo.Info;
import com.connext.ssm.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
     InfoMapper infoMapper;

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        this.infoMapper.delete(id);
    }

    @Override
    public List<Info> queryAll() {
        // TODO Auto-generated method stub
        return this.infoMapper.queryAll();
    }

    @Override
    public Info queryById(Integer id) {
        // TODO Auto-generated method stub
        return this.infoMapper.queryById(id);
    }

    @Override
    public void updateById(Info info) {
        // TODO Auto-generated method stub
        this.infoMapper.updateById(info);
    }

}