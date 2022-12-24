package org.hx.java.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字符串客户
 *
 * @author kyle
 * @date 2022/12/24
 */
public class StringClient {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> res = new HashMap<String, List<String>>();
        for (String str : strs) {

            String sortStr = getMapKey26(str);
            List<String> orDefault = res.getOrDefault(sortStr, new ArrayList<>());
            orDefault.add(str);
            res.put(sortStr, orDefault);
        }
        List<List<String>> collect = new ArrayList<>(res.values());
        System.out.println(collect);
    }

    private static String getMapKey26(String str) {
        int []counts = new int[26];
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            counts[aChar - 'a']++;
        }

        // aab ab

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                sb.append((char) (i+'a'));
            }
        }
        return sb.toString();
    }

    private static String getMapKey(String str) {
        char[] chSort = str.toCharArray();
        Arrays.sort(chSort);
        String sortStr = String.valueOf(chSort);
        return sortStr;
    }
}
