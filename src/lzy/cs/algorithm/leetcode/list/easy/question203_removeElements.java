package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;



// 1-2-6-3-4-5-6
public class question203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1,head);
        ListNode p = root;
        while (p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return root.next;

    }
}

