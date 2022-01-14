package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;
import lzy.cs.algorithm.ListNode;

//[-10,-3,0,5,9,12,13,14]

public class question109_sortedListToBST {
    public BinaryTreeNode sortedListToBST(ListNode head) {
        return convert(head,null);
    }

    public BinaryTreeNode convert(ListNode left,ListNode right){
        if (left == right){
            return null;
        }
        ListNode mid = getMid(left,right);
        BinaryTreeNode root = new BinaryTreeNode(mid.val);
        root.left = convert(left,mid);
        root.right = convert(mid.next,right);
        return root;
    }

    public ListNode getMid(ListNode head,ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
