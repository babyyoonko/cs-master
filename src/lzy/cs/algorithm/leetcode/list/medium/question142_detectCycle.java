package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.ListNode;

public class question142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode root = new ListNode(-1,head);
        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (slow == null || fast == null || fast.next == null){
                break;
            }else {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (slow == fast){
                hasCycle = true;
                break;
            }
        }
        if (hasCycle){
            ListNode p = head;
            while (p != slow){
                p = p.next;
                slow = slow.next;
            }
            return p;
        }else {
            return null;
        }
    }
}
