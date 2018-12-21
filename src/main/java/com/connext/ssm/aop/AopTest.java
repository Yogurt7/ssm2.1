package com.connext.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class AopTest {
    private static Logger LOG = LoggerFactory.getLogger(AopTest.class);

    @Pointcut("execution(* com.connext.ssm.controller.InfoController.queryAll(..))")

    public void queryAll(){

    }
    @Pointcut("execution(* com.connext.ssm.controller.InfoController.updateById(..))")
    public void updateById(){

    }
    @Pointcut("execution(* com.connext.ssm.controller.InfoController.delete(..))")
    public void delete(){

    }
    @Before("queryAll()")
    public void beforequaryAll(JoinPoint joinPoint){
        LOG.info("查询开始了");
        String className =joinPoint.getTarget().getClass().getName();
        String methodName =joinPoint.getSignature().getName();

        System.out.println("前置通知:" + className+ "类的" + methodName + "方法执行了...");
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session =request.getSession();
        System.out.println("用户是:"+session.getAttribute("telephone"));
    }
    @After("queryAll()")
    public void afterqueryAll(JoinPoint joinPoint){
        LOG.info("查询结束");
    }
    @Before("updateById()")
    public  void beforeupdateById(){
        LOG.info("开始修改");

    }
    @After("updateById()")
    public void afterupdateById(){
        LOG.info("修改结束");
    }
    @Before("delete()")
    public  void beforedelete(){
        LOG.info("删除开始");
    }
    @After("delete()")
    public void afterdelete(){
        LOG.info("删除结束");
    }
}
