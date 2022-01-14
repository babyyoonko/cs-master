package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question103_ZZLOT {

    public List<List<Integer>> zigzagLevelOrderTraversal_byRow(BinaryTreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 0;
            while (!queue.isEmpty()) {
                ++level;
                int currentLevelSize = queue.size();
                List<Integer> innerList = new ArrayList<>();
                for (int i = 0; i < currentLevelSize; i++) {
                    BinaryTreeNode p = queue.poll();
                    // 偶数层
                    if ((level & 1) == 0) {
                        innerList.add(0, p.val);
                    } else {
                        innerList.add(p.val);
                    }
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

}
