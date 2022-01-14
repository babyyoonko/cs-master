package lzy.cs.algorithm.leetcode.list.easy;

import lzy.cs.algorithm.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class question141_hasCycle {
    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        HashSet<ListNode> listSet = new HashSet<>();
        while (head != null){
            head = head.next;
            if (!listSet.contains(head)){
                listSet.add(head);
            }else {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

    public boolean hasCycle2(ListNode head) {
        boolean hasCycle = false;
        ListNode fast = head;
        while (true) {
            if (head == null || fast == null || fast.next == null){
                break;
            }
            else{
                head = head.next;
                fast = fast.next.next;
            }
            if (head == fast){
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
}
