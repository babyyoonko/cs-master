package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;


public class question106_buildTree {

    // 中序遍历结点对应索引哈希表
    Map<Integer, Integer> map = new HashMap<>();

    public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, inorder.length - 1);
    }

    public BinaryTreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(postorder[postRight]);
        int inOrderRootIndex = map.get(root.val);
        int leftArrayLength = inOrderRootIndex - inLeft;

        root.left = buildTree(inorder, inLeft, inOrderRootIndex - 1, postorder, postLeft, postLeft + leftArrayLength - 1);
        root.right = buildTree(inorder, inOrderRootIndex + 1, inRight, postorder, postLeft + leftArrayLength, postRight - 1);
        return root;
    }
}
