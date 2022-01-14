package lzy.cs.algorithm.leetcode.binarytree.medium;

import lzy.cs.algorithm.BinaryTreeNode;

public class question236_lowestCommonAncestorOfBST {

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        if (p.val < root.val ^ q.val < root.val){
            return root;
        }else if (p.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }

    public BinaryTreeNode lowestCommonAncestor2(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        BinaryTreeNode ancestor = root;
        while (true){
            if (ancestor == null || p.val == ancestor.val || q.val == ancestor.val){
                break;
            }else if (p.val < ancestor.val ^ q.val < ancestor.val){
                break;
            }else if (p.val < ancestor.val){
                ancestor = ancestor.left;
            }else {
                ancestor = ancestor.right;
            }
        }
        return ancestor;
    }

}
