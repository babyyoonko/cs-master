package lzy.cs.algorithm.leetcode.list.medium;

import lzy.cs.algorithm.BinaryTreeNode;
import lzy.cs.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question114_flatten {
    List<BinaryTreeNode> treeNodeList = new ArrayList<>();

    public BinaryTreeNode flatten(BinaryTreeNode root) {
        pot(root);
        for (int i = 1; i < treeNodeList.size(); i++) {
            BinaryTreeNode prev = treeNodeList.get(i - 1);
            BinaryTreeNode curr = treeNodeList.get(i);
            prev.left = null;
            prev.right = curr;
        }
        return root;
    }

    public void pot(BinaryTreeNode root) {
        if (root != null) {
            treeNodeList.add(root);
            pot(root.left);
            pot(root.right);
        }
    }

    public BinaryTreeNode flatten2(BinaryTreeNode root) {
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            stack.push(root);
            BinaryTreeNode prev = null;
            while (!stack.isEmpty()) {
                BinaryTreeNode p = stack.pop();
                if (prev != null) {
                    prev.left = null;
                    prev.right = p;
                }
                prev = p;
                if (p.right != null) {
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }
        }
        return root;
    }

    public BinaryTreeNode flatten3(BinaryTreeNode root) {
        BinaryTreeNode p = root;
        while (p != null) {
            if (p.left != null) {
                BinaryTreeNode predecessor = p.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = p.right;
                p.right = p.left;
                p.left = null;
            }
            p = p.right;
        }
        return root;
    }
}
