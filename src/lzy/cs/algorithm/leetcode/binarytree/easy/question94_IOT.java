package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question94_IOT {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> inOrderTraversal(BinaryTreeNode root) {
        if(root != null){
            inOrderTraversal(root.left);
            list.add(root.val);
            inOrderTraversal(root.right);
        }
        return list;
    }

    public List<Integer> inOrderTraversal_nonRecursively(BinaryTreeNode root) {
        if(root != null){
            Stack<BinaryTreeNode> stack = new Stack<>();
            BinaryTreeNode p = root;
            while (!stack.isEmpty() || p != null){
                while (p != null){
                    stack.push(p);
                     p = p.left;
                }
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }
}
