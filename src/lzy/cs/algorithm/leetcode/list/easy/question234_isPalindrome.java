package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;

import java.util.Stack;

import static lzy.cs.algorithm.ListNodeOPT.printList;

// 1-2-3-4-5

// 1-2-2-1
// 1-2-3-2-1
// 1-3-2-4-3-2-1
// 1-3-2-4-2-3-1
public class question234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        // 链表长度为奇数数,从slow的下一个开始压栈
        if (fast != null && fast.next == null){
            slow = slow.next;
        }
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            if (head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = slow.next;
        while (p != null && p.next != null) {
            ListNode next = p.next;
            p.next = next.next;
            next.next = slow.next;
            slow.next = next;
        }
        printList(head);
        // 开始遍历
        slow = slow.next;
        while (slow != null){
            if (head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}

