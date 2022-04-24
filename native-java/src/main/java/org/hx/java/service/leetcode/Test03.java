package org.hx.java.service.leetcode;

import org.junit.Test;

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
}
