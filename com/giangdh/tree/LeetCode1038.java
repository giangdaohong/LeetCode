package com.giangdh.tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1038 {
    public static void main(String[] args) {
        System.out.println("Here we go");

        TreeNode root = new LeetCode1038().new TreeNode(7);
        root.right = new LeetCode1038().new TreeNode(8);
        new LeetCode1038().bstToGst(root);
    }

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        helper(root,lst);
        return root;
    }

    int currentMax = 0;
    public void helper(TreeNode root, List<Integer> lst) {
        if (root == null) return;
        helper(root.right, lst);
        currentMax += root.val;
        helper(root.left, lst);
        //currentMax += root.val;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
