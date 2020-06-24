package com.xue.shiro;


import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;


import javax.security.auth.Subject;

public class Test {

    @org.junit.Test
    public void testHelloWorld() {
        Factory<SecurityManager> securityManager = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityUtils.setSecurityManager(securityManager.getInstance());
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhan1g", "123");
        try{
            subject.login(token);
            System.out.println("登录成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();


    }

}
