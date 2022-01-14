package lzy.cs.algorithm.leetcode.binarytree.medium;


import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 1 2 3 4 5
public class question95_generateTrees {
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
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<BinaryTreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<BinaryTreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (BinaryTreeNode left : leftTrees) {
                for (BinaryTreeNode right : rightTrees) {
                    BinaryTreeNode currTree = new BinaryTreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
