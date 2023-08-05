package com.hx.ddd.infrastructure.util;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

public class StringConvertTest {

    @SneakyThrows
    @Test
    public void name() {
        String input = "\\u0001";


        String encode = CharSetUtils.toUTF_8(input);

        System.out.println(encode);

        String sJava="\\u0048\\u0065\\u006C\\u006C\\u006F";
        System.out.println("StringEscapeUtils.unescapeJava(sJava):\n" + StringEscapeUtils.unescapeJava(input));



    }
}
