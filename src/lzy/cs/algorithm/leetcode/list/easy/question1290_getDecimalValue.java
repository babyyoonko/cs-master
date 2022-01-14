package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;


// 1-0-1-1 = 11
//
public class question1290_getDecimalValue {

    public int getDecimalValue(ListNode head) {
        int value = 0;
        while (head != null){
            value = value * 2 + head.val;
            head = head.next;
        }
        return value;
    }
}

