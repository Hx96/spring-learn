package org.hx.java.leetcode.linkedlist;

/**
 * @author kyle
 * @date 2024/01/03
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}

    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode build(String input) {
        // 去除输入字符串中的空格和方括号
        input = input.replace(" ", "").replace("[", "").replace("]", "");
        // 将逗号分隔的数字转换为整数数组
        String[] numbers = input.split(",");
        ListNode ret = new ListNode();
        ListNode cur = ret;
        for (String number : numbers) {
            cur.next = new ListNode(Integer.parseInt(number));
            cur = cur.next;
        }
        return ret.next;
    }

    public static void show (ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
