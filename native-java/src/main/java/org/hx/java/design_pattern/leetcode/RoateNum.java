package org.hx.java.design_pattern.leetcode;

public class RoateNum {

    public static void main(String[] args) {
        int[]nums = new int[] {
                4,5,6,7,0,1,2
        };

        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        // 前提左右两边肯定含有有序，数组，在有序数组中查找
        while(l <= r) {
            int mid = (l+r) / 2;
            System.out.println(mid);

            // 终止条件
            if(nums[mid] == target) {
                return mid;
            }
            // 数组一分为2，一定一个是有序，另一个部分有序，有序二分法，无序再一分为2.
            if(nums[l] <= nums[mid]) {
                // l - mid 有序
                if(target>=nums[l] && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if(target>nums[mid] && target <= nums[r]) {
                    l = mid+1;
                } else {
                    r = mid -1;
                }
            }

        }
        return -1;

    }
}
