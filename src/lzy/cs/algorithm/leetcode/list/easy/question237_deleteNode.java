package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;


// 1-2-6-3-4-5-6
public class question237_deleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

