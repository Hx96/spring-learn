package org.hx.java.service.leetcode;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XingHuang
 */
public class Test03 {

    @Test
    public void testMap() {
        String str = "23123";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        Map<Integer, Character> map= new HashMap<>();
        map.containsValue("");
    }

    @Test
    public void testInt() {
        int[] nums1 = new int []{1 ,2 ,3};
        int a = 1,b=2;
        int c= a<b? a:b;
        System.out.println(c);
        System.out.println(nums1.length);
    }

    @Test
    public void testAnno(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "org.hx.java.service.leetcode");
//        ctx.scan();
//        ctx.refresh();
        System.out.println(ctx.getBean("myLifeCycle"));
//        ctx.start();
//        ctx.close();
    }
}
