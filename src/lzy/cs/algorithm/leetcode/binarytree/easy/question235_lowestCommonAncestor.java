package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

public class question235_lowestCommonAncestor {

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val) {
            return root;
        }
        BinaryTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null || right != null) {
            return left != null ? left : right;
        } else {
            return null;
        }
    }

}
