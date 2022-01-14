package lzy.cs.algorithm;

import lzy.cs.algorithm.leetcode.list.easy.*;
import lzy.cs.algorithm.leetcode.list.medium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListNodeOPT {
//    1999999999
//  +         88
//  = 2000000087

    public static void main(String[] args) {
        ListNode head = createList(null);
//        System.out.println(new question203_removeElements().removeElements(head,6));
        System.out.println(new question1290_getDecimalValue().getDecimalValue(head));
//        printList(new question876_middleNode().middleNode(head));

    }

    // 以非数字为结束输入
    public static ListNode createList(ListNode head) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int val = in.nextInt();
            head = new ListNode(val);
            head.next = createList(null);
        }
        return head;
    }

    public static void printList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list);
    }
}
