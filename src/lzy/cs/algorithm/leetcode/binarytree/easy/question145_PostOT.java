package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question145_PostOT {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> postOrderTraversal(BinaryTreeNode root) {
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }

    public List<Integer> postOrderTraversal_nonRecursively(BinaryTreeNode root) {
        if(root != null){
            Stack<BinaryTreeNode> stack = new Stack<>();
            BinaryTreeNode p = root;
            BinaryTreeNode prev = null;
            while (!stack.isEmpty() || p != null){
                while (p != null){
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if(p.right == null || p.right == prev){
                    list.add(p.val);
                    prev = p;
                    p = null;
                }else{
                    stack.push(p);
                    p = p.right;
                }
            }

        }
        return list;
    }
}
