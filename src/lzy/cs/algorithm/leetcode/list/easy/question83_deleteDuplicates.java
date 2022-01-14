package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;

// 1 3 5
// 2 4 6

// 1 2 4
// 5

public class question83_deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-101, head);
        ListNode p = root;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return root.next;
    }
}
