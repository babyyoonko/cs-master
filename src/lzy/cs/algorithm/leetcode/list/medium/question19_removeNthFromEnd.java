package lzy.cs.algorithm.leetcode.list.medium;


import lzy.cs.algorithm.ListNode;
// n=3
//           |
// 1 2 3 4 5 6 7 8
// n=6
//             |
// 1 2 3 4 5 6 7 8 9 10 11 12
// n=8
// 1 2 3 4 5 6 7 8 9 10
public class question19_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode curr = head;
        ListNode preCurr = null;
        while (fast != null){
            preCurr = curr;
            fast = fast.next;
            curr = curr.next;
        }
        if (preCurr == null){
            head = head.next;
        }
        else if (preCurr.next != null){
            preCurr.next = preCurr.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode fast = head;
        ListNode curr = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            curr = curr.next;
            fast = fast.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
