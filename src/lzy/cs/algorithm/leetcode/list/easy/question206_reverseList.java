package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;


// 1-2 5-4-3
public class question206_reverseList {

    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode preP = null;
        while (p != null) {
            ListNode q = p.next;
            p.next = preP;
            preP = p;
            p = q;
        }
        return preP;
    }

}


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
