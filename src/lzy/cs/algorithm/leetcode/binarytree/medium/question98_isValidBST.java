package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class question98_isValidBST {
//    List<Integer> list = new ArrayList<>();
//
//    public boolean isValidBST(BinaryTreeNode root) {
//        inordTraversal(root);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) >= list.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void inordTraversal(BinaryTreeNode root) {
//        if (root != null) {
//            inordTraversal(root.left);
//            list.add(root.val);
//            inordTraversal(root.right);
//        }
//    }






//    int lastValue;
//    boolean firstInit = true;
//
//    public boolean isValidBST(BinaryTreeNode root) {
//        if (root != null) {
//            if (!isValidBST(root.left)) {
//                return false;
//            }
//            if (firstInit || root.val > lastValue) {
//                if (firstInit){
//                    firstInit = false;
//                }
//                lastValue = root.val;
//            } else {
//                return false;
//            }
//            if (!isValidBST(root.right)) {
//                return false;
//            }
//        }
//        return true;
//    }





    boolean firstInit = true;
    int lastValue;

    public boolean isValidBST(BinaryTreeNode root) {
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            BinaryTreeNode p = root;
            while (!stack.isEmpty() || p != null) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if (firstInit) {
                    lastValue = p.val;
                    firstInit = false;
                } else if (p.val <= lastValue) {
                    return false;
                } else {
                    lastValue = p.val;
                }
                p = p.right;
            }
        }
        return true;
    }
}
