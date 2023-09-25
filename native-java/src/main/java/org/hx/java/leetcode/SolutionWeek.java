package org.hx.java.leetcode;

public class SolutionWeek {

    public static void main(String[] args) {
    }

    public String maximumOddBinaryNumber(String s) {
        int returnLen = s.length();
        char[] chars = new char[returnLen];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '0';
        }

        Integer integer = countOne(s);
        for (int i = 0; i < (integer - 1); i++) {
            chars[i] = '1';
        }
        chars[returnLen - 1] = '1';
        return new String(chars);
    }

    public Integer countOne(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                num++;
            }
        }
        return num;
    }
}
