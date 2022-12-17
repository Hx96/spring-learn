package org.hx.java.regex;

import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    public static void main(String[] args) {
        String s = " +,te    st";
        // 把任意多个空格替换为一个空格
        String singleSpacedString = s.replaceAll(" +", " ");
        Assert.assertEquals(" +,te st", singleSpacedString);

        // 捕获url
        s = "http://google.com";
        if (s.matches("http://([a-z]+\\.)+[a-z]+(:[0-9]+)?/")) {
            // then s is a url
            Assert.assertTrue(true);
        }

        s = "2020-03-18";
        Pattern regex = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
        Matcher m = regex.matcher(s);
        if (m.matches()) {
            String year = m.group("year");
            String month = m.group("month");
            String day = m.group("day");
            Assert.assertEquals("2022", year);
            // Matcher.group(name) returns the part of s that matched (?<name>...)
        }
    }
}
