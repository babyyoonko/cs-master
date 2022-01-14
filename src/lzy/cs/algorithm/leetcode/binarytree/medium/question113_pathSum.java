package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class question113_pathSum {
    List<List<Integer>> ans = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> pathSum(BinaryTreeNode root, int targetSum) {
        getAllPath(root, targetSum);
        return ans;
    }

    public void getAllPath(BinaryTreeNode root, int targetSum) {
        if (root != null) {
            stack.push(root.val);
            if (root.left == null && root.right == null) {
                if (targetSum - root.val == 0) {
                    ans.add(new ArrayList<>(stack));
                }
            }else{
                getAllPath(root.left, targetSum - root.val);
                getAllPath(root.right, targetSum - root.val);
            }
            stack.pop();
        }
    }
}
