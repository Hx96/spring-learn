package org.hx.java.leetcode.linkedlist;

public class ReverseListClient {
    public static void main(String[] args) {
        ListNode build = ListNode.build("[1,2,2,1]");
        ListNode.show(build);

        System.out.println(isPalindrome(build));
    }

    public static ListNode reverseNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode midOfList = null;
        ListNode fast = head;
        ListNode slow = head;
        // 找到中点
        while (slow!= null && slow.next != null) {
            fast = fast.next;
            slow = slow.next.next;
        }
        midOfList = fast;

        // 翻转链表
        midOfList = reverseNode(midOfList);

        // 比较
        ListNode tmp = midOfList;
        while (tmp != null) {
            if (head.val != tmp.val) {
                return false;
            }
            head = head.next;
            tmp = tmp.next;
        }

        // 翻转链表（恢复）
        reverseNode(midOfList);
        return true;
    }


}
