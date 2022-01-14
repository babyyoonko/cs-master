package lzy.cs.algorithm.leetcode.binarytree;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<BinaryTreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<BinaryTreeNode> generateTrees(int start, int end) {
        List<BinaryTreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<BinaryTreeNode> leftTrees = generateTrees(start, i - 1);
            List<BinaryTreeNode> rightTrees = generateTrees(i + 1, end);
            for (BinaryTreeNode p : leftTrees
            ) {
                for (BinaryTreeNode q : rightTrees
                ) {
                    BinaryTreeNode root = new BinaryTreeNode(i);
                    root.left = p;
                    root.right = q;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
