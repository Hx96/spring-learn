package org.hx.java.design_pattern.leetcode;

public class FindFirst {

    public static void main(String[] args) {
        int[] nums = {2,2};
        int[] ints = searchRange(nums, 8);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1;

        int []res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }
        while(l<=r) {
            int mid = (r+l) / 2;
            if(target > nums[mid]) {
                l = mid + 1;
            } else if(target < nums[mid]) {
                r = mid - 1;
            } else {
                r = mid - 1;
            }
        }
        res[0] = l;
        if (target != nums[l]) {
            return res;
        }
        l=0;r=nums.length-1;
        while(l<=r) {
            int mid = (r+l) / 2;
            if(target > nums[mid]) {
                l = mid + 1;
            } else if(target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        };
        res[1]=r;
        return res;
    }
}
