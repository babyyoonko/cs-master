package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class question100_isSameTree {
    public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public boolean isSameTree2(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            BinaryTreeNode p1 = queue.poll();
            BinaryTreeNode p2 = queue.poll();
            if (p1 == null && p2 == null) {
                continue;
            }
            if (p1 == null ^ p2 == null || p1.val != p2.val) {
                return false;
            }
            queue.offer(p1.left);
            queue.offer(p2.left);
            queue.offer(p1.right);
            queue.offer(p2.right);
        }
        return true;
    }
}
