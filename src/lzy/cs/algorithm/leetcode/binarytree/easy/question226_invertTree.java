package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class question226_invertTree {

    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        return invert(root);
    }

    public BinaryTreeNode invert(BinaryTreeNode root){
        if (root != null){
            BinaryTreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            invert(root.left);
            invert(root.right);
        }
        return root;
    }
}
