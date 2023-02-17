package org.hx.java.leetcode;

/**
 * 任务安排
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 *
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 * @author kyle
 * @date 2023/02/11
 */
public class TaskSchedule {

    public static void main(String[] args) {

    }


    /**
     * 有一批任务要完成，相同任务有一定冷却时间，求最少完成时间
     *
     * 思路: 优先完成任务数最多的任务，在完成任务数最多的任务后穿插完成其他任务。 分两种情况:
     *
     * 次数最多的任务A的cd时间大于其他任务的循环时间，那么最小时间为A全部执行完毕。时间为 (n-1)*间隔时间+n, n为Ad的次数
     * A的cd时间小于其他任务循环完成时间，那么这时候就没有等待的时间了，所有任务都可以完美排期。总时间为len(task_queue)
     *
     * @param tasks 任务
     * @param n     n
     * @return int
     */
    public int leastInterval(char[] tasks, int n) {
        int [] cTasks = new int[26];

        // 冷却为3
        // A x x x
        // A x x x
        // A x x x
        // A
        // 需要时间为 （3+1）* (A的个数-1) + A
        // 任务矩阵执行时间 （n+1）* (maxA-1) + total
        //
        //
        // ["A","A","A","A","A","A","B","C","D","E","F","G"]
        // A B G
        // A C 1
        // A D 1
        // A E 1
        // A F 1
        // A

        // 统计任务
        for (char task : tasks) {
            cTasks[task - 'A'] ++;
        }

        // 计算 第一种情况
        int total=0;
        int maxA=0;
        for (int cTask : cTasks) {
            if(cTask !=0 ) {
                //
                maxA = Math.max(maxA, cTask);
            }
        }
        // A B x
        // A B x
        // A B

        for (int cTask : cTasks) {
            if (cTask == maxA) {
                total++;
            }
        }

        int executeA = (n + 1) * (maxA - 1);


        // 3 * 5 +
        int square = executeA + total;

        return Math.max(square, tasks.length);
    }
}
