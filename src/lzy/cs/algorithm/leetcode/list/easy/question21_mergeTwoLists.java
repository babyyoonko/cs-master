package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;

// 1 3 5
// 2 4 6

// 1 2 4
// 5

public class question21_mergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode root = null;
        ListNode p = null;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                if (p != null) {
                    p.next = p1;
                    p = p.next;
                } else {
                    p = p1;
                }
                p1 = p1.next;
            } else {
                if (p != null) {
                    p.next = p2;
                    p = p.next;
                } else {
                    p = p2;
                }
                p2 = p2.next;
            }
            if (root == null) {
                root = p;
            }
        }

        if (root == null) {
            root = p1 != null ? p1 : p2;
        } else {
            if (p1 == null) {
                p.next = p2;
            }
            if (p2 == null) {
                p.next = p1;
            }
        }
        return root;
    }


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode root = new ListNode();
        ListNode p = root;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 != null ? p1 : p2;
        return root.next;
    }

    // 1 3 5
    // 2 4 6
    public ListNode mergeTwoLists_recursively(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists_recursively(list1.next,list2);
                return list1;
            } else {
                list2.next = mergeTwoLists_recursively(list1,list2.next);
                return list2;
            }
        }
    }

    // 1-2-4
    // 2-3-5-7-9
    public ListNode test(ListNode list1, ListNode list2){
        ListNode root = new ListNode(-1);
        ListNode p = root;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 == null?p2:p1;
        return root.next;
    }
}
