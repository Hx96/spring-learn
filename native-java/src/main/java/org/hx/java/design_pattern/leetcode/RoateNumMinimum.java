package org.hx.java.design_pattern.leetcode;

public class RoateNumMinimum {

    public static void main(String[] args) {
        int[]nums = new int[] {
                4,5,6,7,0,1,2
        };
//        int[]nums = new int[] {
//                3,1,2
//        };

        System.out.println(search(nums));
    }

    public static int search(int[] nums) {
        int l=0,r=nums.length-1;
        if(nums[r] > nums[l]) {
            return nums[0];
        }
        while(l <= r) {
            int mid = (r-l) / 2 + l;
            if (nums[mid] < nums[0]) {
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return nums[r+1];

    }
}
