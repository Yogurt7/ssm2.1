package com.connext.ssm.service.impl;

import com.connext.ssm.mapper.InfoMapper;
import com.connext.ssm.pojo.Info;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestInfoServiceImpl {
    @Autowired
    InfoServiceImpl infoService;
    @Autowired
    InfoMapper infoMapper;
    Info info = new Info(11,"房东的猫111",new Date(2018,12,17),"咿呀咿呀哟");
    @Test
    public void updateById() {
        // TODO Auto-generated method stub
        infoService.updateById(info);
        Info resultInfo = infoService.queryById(info.getId());

        Assert.assertEquals(resultInfo.getContent(), info.getContent());
    }
    @Test
    public void delete() {
        infoService.infoMapper.delete(111);
    }
}
