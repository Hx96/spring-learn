package com.hx.listen;
import java.util.Date;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerTest3 implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        System.out.println("requestDestroyed" + "," + new Date());
        System.out.println("当前访问次数：" + arg0.getServletContext().getAttribute("count"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        System.out.println("requestInitialized" + "," + new Date());
        Object count = arg0.getServletContext().getAttribute("count");
        Integer cInteger = 0;
        if (count != null) {
            cInteger = Integer.valueOf(count.toString());
        }
        System.out.println("历史访问次数：：" + count);
        cInteger++;
        arg0.getServletContext().setAttribute("count", cInteger);
    }
}