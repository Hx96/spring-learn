package com.hx.listen;import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

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
    }
}
