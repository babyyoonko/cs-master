package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.ListNode;

public class question82_deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-999, head);
        ListNode preP = root;
        ListNode p = head;
        while (p != null && p.next != null) {
            if(p.val == p.next.val){
                while (p != null && preP.next.val == p.val) {
                    p = p.next;
                }
                preP.next = p;
            }
            else {
                preP = preP.next;
                p = p.next;
            }
        }
        return root.next;
    }
}
