package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class question437_pathSumIII {

    public int pathSum(BinaryTreeNode root, int targetSum) {
        int pathCount = 0;
        if (root != null){
            pathCount += (rootSum(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum));
        }
        return pathCount;
    }

    public int rootSum(BinaryTreeNode root, int targetSum){
        int pathCount = 0;
        if (root != null){

            if (targetSum-root.val == 0){
                pathCount++;
            }
            pathCount += (rootSum(root.left,targetSum-root.val) + rootSum(root.right,targetSum-root.val));
        }
        return pathCount;
    }
}
