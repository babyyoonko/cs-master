package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.Stack;


public class question110_isBalanced {

//    public boolean isBalanced(BinaryTreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        int leftHeight = dfs(root.left);
//        int rightHeight = dfs(root.right);
//        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    public int dfs(BinaryTreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = dfs(root.left);
//        int right = dfs(root.right);
//        return Math.max(left, right) + 1;
//    }

    public boolean isBalanced(BinaryTreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1){
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1){
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
