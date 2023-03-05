package com.hx.listen;

import com.hx.inter.RegionIsolationHolder;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class MyRequestListener implements ServletRequestListener{
    private ServletContext sc;
    private Integer count;
    @Override
    //请求被初始化 Request
    public void requestInitialized(ServletRequestEvent sre) {
        //获取全局域
        sc = sre.getServletContext();
        //将count从全局域中获取出来
        count = (Integer) sc.getAttribute("count");
        System.out.println(count);
        count++;
        System.out.println(count);
        sc.setAttribute("count",count);
        RegionIsolationHolder.set(111L);
    }
}
