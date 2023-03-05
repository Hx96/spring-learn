package com.hx.listen;

import com.hx.inter.RegionIsolationHolder;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
        RegionIsolationHolder.set(113L);

    }
}