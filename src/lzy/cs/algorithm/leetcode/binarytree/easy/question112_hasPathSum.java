package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;
import lzy.cs.algorithm.ListNode;



public class question112_hasPathSum {
    public boolean hasPathSum(BinaryTreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left,targetSum-root.val)|| hasPathSum(root.right,targetSum-root.val);
    }
//    int sum = 0;
//    public boolean hasPathSum(BinaryTreeNode root, int targetSum) {
//        if (root == null){
//            return false;
//        }
//        if (root.left == null && root.right == null){
//            return sum + root.val == targetSum;
//        }
//        sum += root.val;
//        if (hasPathSum(root.left,targetSum)|| hasPathSum(root.right,targetSum)){
//            return true;
//        }else {
//            sum -= root.val;
//            return false;
//        }
//    }
}
