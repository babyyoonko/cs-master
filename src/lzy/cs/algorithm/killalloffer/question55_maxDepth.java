package lzy.cs.algorithm.killalloffer;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class question55_maxDepth {
    public int maxDepth_recursive(BinaryTreeNode root) {
        return dfs(root);
    }

    public int dfs(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth(BinaryTreeNode root) {
        int maxDepth = 0;
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                maxDepth += 1;
                for (int i = 0; i < currentLevelSize; i++) {
                    BinaryTreeNode p = queue.poll();
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                }
            }

        }
        return maxDepth;
    }
}
