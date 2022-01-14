package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.ListNode;


public class question2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = null;
        ListNode root = null;
        ListNode q = null;

        int carry = 0;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            if (sum >= 10){
                carry = 1;
                sum %= 10;
            }else {
                carry = 0;
            }
            p = new ListNode(sum);
            if (root == null){
                root = p;
            }
            if (q != null){
                q.next = p;
            }
            q = p;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int sum = l1.val + carry;
            if (sum >= 10){
                carry = 1;
                sum %= 10;
            }else {
                carry = 0;
            }
            p = new ListNode(sum);
            q.next = p;
            q = p;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = l2.val + carry;
            if (sum >= 10){
                carry = 1;
                sum %= 10;
            }else {
                carry = 0;
            }
            p = new ListNode(sum);
            q.next = p;
            q = p;
            l2 = l2.next;
        }
        if (carry == 1) {
            p = new ListNode(1);
            q.next = p;
        }
        return root;
    }
}
