package org.hx.java.leetcode;

/**
 * 每周客户
 *
 * @author kyle
 * @date 2023/03/05
 */
public class WeeklyClient {

    public int[] plusOne(int[] digits) {
        int cnt = 0;
        int[] result = new int[digits.length + 1];
        int j=0;
        for (int i = digits.length-1; i >= 0; i--) {

            if (i == digits.length - 1) {
                cnt = (digits[i]+1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            } else {
                int temp = (digits[i] + cnt) / 10;
                digits[i] = (digits[i] + cnt) % 10;
                cnt = temp;
            }
        }
        if (cnt != 0) {
            result[0] = cnt;
            for (int i = 1; i < digits.length; i++) {
                result[i] = digits[i];
            }
            return result;
        }
        return digits;
    }
}
