package lzy.cs.algorithm.leetcode.binarytree.easy;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class question501_findMode {
    List<Integer> ans = new ArrayList<>();
    int count = 0;
    int maxCount = 0;
    int base;
    // root is *BST*
    public int[] findMode(BinaryTreeNode root) {
        find(root);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public void find(BinaryTreeNode root){
        if (root != null){
            find(root.left);
            if (root.val != base){
                count = 1;
                base = root.val;
            }else {
                count ++;
            }
            if (count > maxCount){
                maxCount = count;
                ans.clear();
                ans.add(base);
            }else if(count == maxCount){
                ans.add(base);
            }
            find(root.right);
        }
    }
}
