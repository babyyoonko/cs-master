package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question144_POT {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preOrderTraversal(BinaryTreeNode root) {
        if(root != null){
            list.add(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
        return list;
    }

    public List<Integer> preOrderTraversal_nonRecursively(BinaryTreeNode root) {
        if(root != null){
            Stack<BinaryTreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                BinaryTreeNode binaryTreeNode = stack.pop();
                list.add(binaryTreeNode.val);
                if(binaryTreeNode.right != null){
                    stack.push(binaryTreeNode.right);
                }
                if(binaryTreeNode.left != null){
                    stack.push(binaryTreeNode.left);
                }
            }
        }
        return list;
    }
}
