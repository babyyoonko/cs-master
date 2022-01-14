package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

//    1
//  2
//    3


public class question105_buildTree {

//    public BinaryTreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
//        if (preLeft > preRight || inLeft > inRight) {
//            return null;
//        }
//        BinaryTreeNode root = new BinaryTreeNode(preorder[preLeft]);
//        int inOrderRootIndex = -1;
//        for (int i = inLeft; i <= inRight; i++) {
//            if (inorder[i] == root.val) {
//                inOrderRootIndex = i;
//                break;
//            }
//        }
//        // 先序遍历的右子树序列的开始索引
//        int preOrderRightTreeStartIndex = preLeft + 1;
//        for (int i = preLeft + 1; i <= preRight; i++) {
//            // 判断先序遍历里哪个元素不在中序遍历划分出的左子树中
//            boolean existInorderLeftArray = false;
//            for (int j = inLeft; j <= inOrderRootIndex - 1; j++) {
//                if (preorder[i] == inorder[j]) {
//                    preOrderRightTreeStartIndex++;
//                    existInorderLeftArray = true;
//                    break;
//                }
//            }
//            if (!existInorderLeftArray) {
//                break;
//            }
//        }
//        root.left = buildTree(preorder, preLeft+1, preOrderRightTreeStartIndex - 1, inorder, inLeft, inOrderRootIndex - 1);
//        root.right = buildTree(preorder, preOrderRightTreeStartIndex, preRight, inorder, inOrderRootIndex + 1, inRight);
//        return root;
//    }

    // 中序遍历结点对应索引哈希表
    Map<Integer, Integer> map = new HashMap<>();

    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public BinaryTreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preorder[preLeft]);
        int inOrderRootIndex = map.get(root.val);
        int leftArrayLength = inOrderRootIndex - inLeft;

        root.left = buildTree(preorder, preLeft + 1, preLeft + leftArrayLength, inorder, inLeft, inOrderRootIndex - 1);
        root.right = buildTree(preorder, preLeft + leftArrayLength + 1, preRight, inorder, inOrderRootIndex + 1, inRight);
        return root;
    }
}
