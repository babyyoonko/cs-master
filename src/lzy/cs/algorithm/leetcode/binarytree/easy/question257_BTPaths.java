package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question257_BTPaths {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(BinaryTreeNode root) {
        getAllPaths(root, "");
        return ans;
    }

    public void getAllPaths(BinaryTreeNode root, String path) {
        if (root != null) {
            path += String.valueOf(root.val);
            if (root.left == null && root.right == null) {
                ans.add(path);
            } else {
                path += "->";
                getAllPaths(root.left, path);
                getAllPaths(root.right, path);
            }
        }
    }
}
