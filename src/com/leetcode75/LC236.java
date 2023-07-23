package com.leetcode75;

public class LC236 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return tr;
    }

    TreeNode tr;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean rs = false;
        if (root.val != p.val && root.val != q.val) {
            if (dfs(root.left, p, q)) {
                tr = root;
                return true;
            }
            if (dfs(root.right, p, q)) {
                tr = root;
                return true;
            }
        }

        if (root.val == p.val) {
            if (help(root.left, q) || help(root.right, q)) {
                tr = root;
                return true;
            }
        }

        if (root.val == q.val) {
            if (help(root.left, p) || help(root.right, p)) {
                tr = root;
                return true;
            }
        }

        rs = (help(root.left, p) && help(root.right, q)) || (help(root.left, q) && help(root.right, p));

        if (rs) {
            tr = root;
        }
        return rs;
    }

    boolean help(TreeNode root, TreeNode x) {
        if (root == null) return false;
        if (root.val == x.val) return true;
        return help(root.left, x) || help(root.right, x);
    }
}
