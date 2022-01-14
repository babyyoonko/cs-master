package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//         9
//      0     13
//   -3   5 12   14
//-10
//[-10,-3,0,5,9,12,13,14]
public class question108_sortedArrayToBST {
    public BinaryTreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    public BinaryTreeNode convert(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(nums[(left + right) / 2]);
        root.left = convert(nums, left, (left + right) / 2 - 1);
        root.right = convert(nums, (left + right) / 2 + 1, right);
        return root;
    }

}
