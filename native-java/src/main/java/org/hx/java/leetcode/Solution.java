package org.hx.java.leetcode;


class Solution {

//    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

    public ListNode reverseList(ListNode head) {

        // cur pre

        return travel(head, null);

    }

    private ListNode travel(ListNode cur, ListNode pre) {
        if (cur == null) {
             return pre;
        }

        ListNode result = travel(cur.next, cur);
        // pre(node) cur(null)
        cur.next = pre;

        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}