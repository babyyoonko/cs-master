package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class question111_minDepth {
    public int minDepth_recursively(BinaryTreeNode root) {
        return dfs(root);
    }


    public int dfs(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        if (leftDepth == 0) {
            return rightDepth + 1;
        }
        if (rightDepth == 0) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepth(BinaryTreeNode root) {
        int minDepth = 0;
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                minDepth++;
                for (int i = 0; i < currentLevelSize; i++) {
                    BinaryTreeNode p = queue.poll();
                    if (p.left == null && p.right == null) {
                        return minDepth;
                    }
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                }

            }
        }
        return minDepth;
    }
}
