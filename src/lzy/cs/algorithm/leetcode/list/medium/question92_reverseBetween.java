package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.ListNode;

import static lzy.cs.algorithm.ListNodeOPT.printList;


//  1-2-3-4-5-6-7   left=2,right=6
// :1-6-5-4-3-2-7
public class question92_reverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(-1, head);
        ListNode p = root;
        ListNode q = root;
        int steps = 1;
        while (steps < left) {
            p = p.next;
            q = q.next;
            ++steps;
        }
        while (steps < right) {
            q = q.next;
            steps++;
        }
        // succ是子链表反转后应该接的尾巴，prec是子链表反转后的头
        ListNode prec = q.next;
        ListNode succ = q.next.next;
        ListNode newListRear = reverseBetween(p.next, q.next);
        newListRear.next = succ;
        p.next = prec;
        return root.next;
    }

    //head            rear
    // 2 - 3 - 4 - 5 - 6        ————>   6 - 5 - 4 - 3 - 2 - root
    //head                    rear
    // 1 - 2 - 3 - 4 - 5 - 6 - 7
    public ListNode reverseBetween(ListNode head, ListNode rear) {
        ListNode root = new ListNode(-1, head);
        ListNode p = head;
        ListNode preP = root;
        while (preP != rear){
            ListNode q = p.next;
            p.next = preP;
            preP = p;
            p = q;
        }
        return head;
    }

    // 1 - 2 - 3 - 4 - 5
    // 1 - 3 - 2 - 4 - 5
    public ListNode reverseBetween_head_insertion(ListNode head, int left, int right) {
        ListNode root = new ListNode(-1,head);
        ListNode p = root.next;
        ListNode preP = root;
        int steps = 1;
        while (steps < left){
            p = p.next;
            preP = preP.next;
            ++steps;
        }
        while (steps < right){
            ListNode newHead = p.next;
            p.next = newHead.next;
            newHead.next = preP.next;
            preP.next = newHead;
            ++steps;
        }
        return root.next;
    }
}
