package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.ListNode;

import static lzy.cs.algorithm.ListNodeOPT.printList;


public class question24_swapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head != null) {
            return swapPairs(head, head.next);
        }
        return head;
    }

    public ListNode swapPairs(ListNode p, ListNode q) {
        if (p == null || q == null) {
            return p;
        }
        ListNode nextPairs;
        if (q.next == null) {
            nextPairs = swapPairs(null, null);
        } else {
            nextPairs = swapPairs(q.next, q.next.next);
        }
        q.next = p;
        p.next = nextPairs;
        return q;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode headNode = new ListNode(-1, head);
        ListNode p = headNode;
        while (p.next != null && p.next.next != null){
            ListNode q = p.next;
            ListNode t = q.next;
            p.next = t;
            q.next = t.next;
            t.next = q;
            p = q;
        }
        return headNode.next;
    }
}
