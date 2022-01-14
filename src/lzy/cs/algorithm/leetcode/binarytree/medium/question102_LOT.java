package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.*;

public class question102_LOT {

    public List<List<Integer>> levelOrderTraversal_byRow(BinaryTreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                List<Integer> innerList = new ArrayList<>();
                for (int i = 0; i < currentLevelSize; ++i) {
                    BinaryTreeNode p = queue.poll();
                    innerList.add(p.val);
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                }
                list.add(innerList);
            }
        }
        return list;
    }

    public List<Integer> levelOrderTraversal(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                BinaryTreeNode p = queue.poll();
                list.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return list;
    }

    public List<List<String>> levelOrderTraversal_byRowWithNull(BinaryTreeNode root) {
        List<List<String>> list = new ArrayList<>();
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                List<String> innerList = new ArrayList<>();
                for (int i = 0; i < currentLevelSize; ++i) {
                    BinaryTreeNode p = queue.poll();
                    if (p != null){
                        innerList.add(String.valueOf(p.val));
                        queue.offer(p.left);
                        queue.offer(p.right);
                    }else {
                        innerList.add("null");

                    }
                }
                list.add(innerList);
            }
        }
        return list;
    }
}
