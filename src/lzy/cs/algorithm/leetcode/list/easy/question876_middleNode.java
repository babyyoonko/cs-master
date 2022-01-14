package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;


// 1-2-6-3-4-5-6
// 1-2-6-3-5-6
public class question876_middleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

