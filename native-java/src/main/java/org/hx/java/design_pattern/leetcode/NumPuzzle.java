package org.hx.java.design_pattern.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kyle
 */
public class NumPuzzle {

    static int [] nums = new int[] {4,3,2,7,8,2,3,1};
//    static int [] nums = new int[] {1,1};
    public static void main(String[] args) {

        ArrayList<Integer> ret = new ArrayList<>();
        int len = nums.length;

        for (int num : nums) {
            // 找到出现的下标，下标需要减1
            // 下标小于1
            num = (num - 1) % len;
            nums[num] += len;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= len) {
                ret.add(i+1);
            }
        }

        System.out.println(ret);
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
