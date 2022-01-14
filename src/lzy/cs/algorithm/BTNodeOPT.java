package lzy.cs.algorithm;


import lzy.cs.algorithm.leetcode.binarytree.easy.question257_BTPaths;
import lzy.cs.algorithm.leetcode.binarytree.easy.question404_sumOfLeftLeaves;
import lzy.cs.algorithm.leetcode.binarytree.easy.question501_findMode;
import lzy.cs.algorithm.leetcode.binarytree.medium.*;
import lzy.cs.algorithm.leetcode.list.medium.question114_flatten;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BTNodeOPT {

    public static void main(String[] args) {
        BinaryTreeNode root = createBinaryTree(null);
//        BinaryTreeNode root = new question106_buildTree().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
//        List<List<String>> ans = new question102_LOT().levelOrderTraversal_byRowWithNull(root);
//        for (List<String> row : ans
//        ) {
//            for (String node : row
//            ) {
//                System.out.print(node);
//                System.out.print(' ');
//            }
//            System.out.println();
//        }
        printBinaryTree(new question114_flatten().flatten3(root));
//        System.out.println(new question114_flatten().flatten(root));
//        ListNode head = createList(null);
//        printBinaryTree(new question109_sortedListToBST().sortedListToBST(head));
//        List<List<Integer>> list = new question103_ZZLOT().zigzagLevelOrderTraversal_byRow(root);
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) {
//                System.out.print(list.get(i).get(j));
//                System.out.print(' ');
//            }
//            System.out.println();
//        }
    }

    // 以非数字为结束输入
    public static BinaryTreeNode createBinaryTree(BinaryTreeNode root) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int val = in.nextInt();
            root = new BinaryTreeNode(val);
            root.left = createBinaryTree(null);
            root.right = createBinaryTree(null);
        }
        return root;
    }

    // 按行层次遍历打印二叉树
    public static void printBinaryTree(BinaryTreeNode root) {
        List<List<Integer>> list = new question102_LOT().levelOrderTraversal_byRow(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
