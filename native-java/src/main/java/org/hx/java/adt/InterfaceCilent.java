package org.hx.java.adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface IllegalAr {
    public static final Integer a = 20;

    int b =200;

    static Integer testShow() {
        return b;
    }
}


public class InterfaceCilent {


    public static void main(String[] args) {
        System.out.println(IllegalAr.testShow());
        List<String> abc = new ArrayList<>(Collections.singletonList("abc"));
        Object obj = abc;
        System.out.println(obj.toString());
        obj = "xxx";
        System.out.println(obj);
    }
}
