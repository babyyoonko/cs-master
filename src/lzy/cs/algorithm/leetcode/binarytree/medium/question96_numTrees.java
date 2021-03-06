package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

import java.util.Stack;


public class question96_numTrees {

    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            G[i] = 0;
            for (int j = 1; j <= i ; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
