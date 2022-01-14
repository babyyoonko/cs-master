package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//    1
//  2   2
//2    2
// ^2^2^1^2^2^
//^3^2^4^1^4^2^3^
// 11222233444433

public class question101_isSymmetric {

    public boolean isSymmetric(BinaryTreeNode root) {
        return check(root, root);
    }

    public boolean check(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null ^ q == null || p.val != q.val) {
            return false;
        } else {
            return check(p.left,q.right) && check(p.right,q.left);
        }
    }


    public boolean isSymmetric2(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode p = queue.poll();
            BinaryTreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null ^ q == null || p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }

}
