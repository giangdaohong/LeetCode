package com.leetcode75;

public class LC1372 {

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

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return max;
    }

    int max = 0;

    void dfs(TreeNode root, boolean left, int cnt) {
        if (root == null) {
            return;
        }
        max = Math.max(max, cnt);
        if (left) {
            if (root.right != null) {
                dfs(root.right, false, cnt + 1);
            }
            if (root.left != null) {
                dfs(root.left, true, 1);
            }
        } else {
            if (root.left != null) {
                dfs(root.left, true, cnt + 1);
            }
            if (root.right != null) {
                dfs(root.right, false, 1);
            }
        }
    }
}
