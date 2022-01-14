package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question662_WOBT {

    public int widthOfBinaryTree(BinaryTreeNode root) {
        int maxWidth = 0;
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> indexList = new ArrayList<>();
            indexList.add(1);
            while (!queue.isEmpty()) {
                int currentLevelWidth = indexList.get(indexList.size() - 1) - indexList.get(0) + 1;
                maxWidth = Math.max(currentLevelWidth, maxWidth);
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    BinaryTreeNode p = queue.poll();
                    int rootIndex = indexList.remove(0);
                    if (p.left != null) {
                        queue.offer(p.left);
                        indexList.add(rootIndex * 2);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                        indexList.add(rootIndex * 2 + 1);
                    }
                }

            }
        }
        return maxWidth;
    }

//    public int widthOfBinaryTree_mySolution(BinaryTreeNode root) {
//        int maxWidth = 0;
//        if (root != null) {
//            Queue<BinaryTreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//            maxWidth = 1;
//            while (!queue.isEmpty()) {
//                int currentLevelSize = queue.size();
//                // 有效结点距离，即最右非空结点离最左非空结点的距离;-1为未找到第一个有效结点的值（即刚开始全是空结点）;
//                // 当找到第一个有效结点时，从右开始算有效结点数，具体算法该变量为是否遇到非空结点，遇到了才把距离算进有效结点距离
//                int validNodesDistance = -1;
//                int distance = 1;
//                // 如果当前层全是空结点，那就直接退出算法了
//                boolean isAllNull = true;
//                for (int i = 0; i < currentLevelSize; i++) {
//                    BinaryTreeNode p = queue.poll();
//                    // 不管是空还是真实的结点，都放进队列
//                    if (p != null) {
//                        isAllNull = false;
//                        queue.offer(p.left != null ? p.left : null);
//                        queue.offer(p.right != null ? p.right : null);
//                    }else {
//                        queue.offer(null);
//                        queue.offer(null);
//                    }
//
//                    if (p != null) {
//                        if (validNodesDistance == -1) {
//                            validNodesDistance = 1;
//                        } else {
//                            validNodesDistance += distance;
//                        }
//                        distance = 1;
//                    } else {
//                        distance++;
//                    }
//                }
//                if(isAllNull){
//                    break;
//                }
//                maxWidth = Math.max(validNodesDistance, maxWidth);
//            }
//        }
//        return maxWidth;
//    }
}
