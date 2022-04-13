package com.hx.client;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author XingHuang
 */
public class ShiroTest {
    public static void main(String[] args) {
        //1.根据.ini配置文件获取SecurityManagerFactory
        IniSecurityManagerFactory factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.使用工厂获取SecurityManager示例
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3.获取主体
        Subject subject = SecurityUtils.getSubject();
        //4.封装token
        UsernamePasswordToken token = new UsernamePasswordToken("zwq", "22");
        //5.执行认证逻辑：登录
        subject.login(token);
        //6.判断是否认证成功
        System.out.println("用户是否认证："+subject.isAuthenticated());
        //7.退出
        Session session = subject.getSession();
        System.out.println(session.toString());
        subject.logout();
        //8.再次判断是否认证成功
        System.out.println("用户是否认证："+subject.isAuthenticated());
    }
}
