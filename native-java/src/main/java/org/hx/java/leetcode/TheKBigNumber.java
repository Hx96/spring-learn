package org.hx.java.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * kbig数量
 *
 * @author kyle
 * @date 2023/02/18
 */
public class TheKBigNumber {

    public static void main(String[] args) {
        //natural ordering example of priority queue
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        integerPriorityQueue.add(10);
        integerPriorityQueue.add(11);
        integerPriorityQueue.add(3);
        integerPriorityQueue.add(5);
        Integer poll = integerPriorityQueue.poll();
        System.out.println(integerPriorityQueue);

    }

    public int findKthLargest(int[] nums, int k) {
        // 定义一个数组依次插入
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            integerPriorityQueue.add(num);
        }
        Integer result = 0;
        for (int i = 0; i < k; i++) {
            result = integerPriorityQueue.poll();
        }
        return result;
    }
}
