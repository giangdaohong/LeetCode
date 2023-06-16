package com.google;

/**
 * 114. Flatten Binary Tree to Linked List
 */
public class LeetCode114 {
    public static void main(String[] args) {
        TreeNode root = new LeetCode114().new TreeNode(1);
        root.right = new LeetCode114().new TreeNode(5);
        root.right.right = new LeetCode114().new TreeNode(6);

        root.left = new LeetCode114().new TreeNode(2);
        root.left.left = new LeetCode114().new TreeNode(3);
        root.left.right = new LeetCode114().new TreeNode(4);

        new LeetCode114().flatten(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
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
