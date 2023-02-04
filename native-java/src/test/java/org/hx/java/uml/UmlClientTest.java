package org.hx.java.uml;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UmlClientTest {

    @Test
    public void name() {
        List<String> list = new ArrayList<>();
        list.add("xx");
        list.add("xx11");
        list.add("xx11");
        String collect = String.join(",", list);
        System.out.println(collect);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme