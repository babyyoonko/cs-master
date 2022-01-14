package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class question404_sumOfLeftLeaves {
    int ans = 0;

    public int sumOfLeftLeaves(BinaryTreeNode root) {
        sumOfLeftLeaves(root,false);
        return ans;
    }
    public int sumOfLeftLeaves(BinaryTreeNode root,boolean isLeftTree) {
        if (root != null){
            if (root.left == null && root.right == null && isLeftTree){
                ans += root.val;
            }else {
                sumOfLeftLeaves(root.left,true);
                sumOfLeftLeaves(root.right,false);
            }
        }
        return ans;
    }
}
