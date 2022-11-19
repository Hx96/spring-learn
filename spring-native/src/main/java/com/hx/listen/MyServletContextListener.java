package com.hx.listen;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class MyServletContextListener implements ServletContextListener{
    private ServletContext sc;
    @Override
    //Application被初始化的时候创建
    public void contextInitialized(ServletContextEvent sce) {
        Integer count = 0;
        //获取全局域
        sc = sce.getServletContext();
        //将count放入到全局域中
        sc.setAttribute("count",count);
    }
}