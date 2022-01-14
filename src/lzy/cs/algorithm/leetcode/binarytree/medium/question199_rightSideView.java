package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class question199_rightSideView {
    List<Integer> ans = new ArrayList<>();
    int level = 0;
    int maxLevel = 0;
    public List<Integer> rightSideView(BinaryTreeNode root) {
        dfs(root);
        return ans;
    }

    public void bfs(BinaryTreeNode root){
        if (root != null){
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int currLevelSize = queue.size();
                for (int i = 0; i < currLevelSize; i++) {
                    BinaryTreeNode p = queue.poll();
                    if (p.left != null){
                        queue.offer(p.left);
                    }
                    if (p.right != null){
                        queue.offer(p.right);
                    }
                    if (i == currLevelSize -1){
                        ans.add(p.val);
                    }
                }
            }
        }
    }

//        1
//      2   3
//    4

    public void dfs(BinaryTreeNode root){
        if (root != null){
            ++level;
            if (maxLevel < level){
                ans.add(root.val);
                maxLevel = level;
            }
            dfs(root.right);
            dfs(root.left);
            --level;
        }
    }
}
