package org.hx.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 动态客户端
 *
 * @author kyle
 * @date 2023/01/14
 */
public class DynamicClient {

     /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
     * nums =
     * [1,2,1,2,1] k=3
     *
     * count = 4
     * @param nums 全国矿工工会
     * @param k    k
     * @return int
     */
    public int subarraySum(int[] nums, int k) {
        // 动态规划 连续子数组
        // 子数据 先排序
//        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++) {
            // 第j个元素结束
            int sum=0;
            for(int j=i;j<nums.length;j++) {
                sum+=nums[j];
                if(sum==k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumM1(int[] nums, int k) {
        // 前缀和
        int count=0;
        Map<Integer,Integer> maps = new HashMap();

        // 1 -1 0
        // 1 1
        // 0 2
        int preSum = 0;
        maps.put(0,1);
        for(Integer num:nums) {

            preSum += num;

            count = count + maps.getOrDefault(preSum - k, 0);

            // 维护前缀和
            maps.put(preSum, maps.getOrDefault(preSum, 1) + 1);
        }

        return count;
    }
}
