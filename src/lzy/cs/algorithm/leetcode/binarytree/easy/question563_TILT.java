package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question563_TILT {
    int ans = 0;
    public int findTilt(BinaryTreeNode root) {
        dfs(root);
        return ans;
    }


    public int dfs(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        ans += Math.abs(leftSum-rightSum);
        return leftSum + rightSum + root.val;

    }
}
