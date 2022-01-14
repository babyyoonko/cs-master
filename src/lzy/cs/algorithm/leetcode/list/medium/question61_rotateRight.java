package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.ListNode;

// 1 2 3 4 5
public class question61_rotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head != null){
            ListNode p = head;
            int length = 0;
            while (p.next != null){
                ++length;
                p = p.next;
            }
            ++length;
            p.next = head;
            ListNode preP = p;
            p = head;
            k %= length;
            for (int i = 0; i < length - k; i++) {
                p = p.next;
                preP = preP.next;
            }
            head = p;
            preP.next = null;
        }
        return head;
    }
}
