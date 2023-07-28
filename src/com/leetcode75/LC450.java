package com.leetcode75;

public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        dfs(root, key);
        return root;
    }


    void dfs(TreeNode root, int key) {
        if (root == null) return;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            if (root.left == null) {
                int tm = root.val;
                root.val = root.right.val;
                root.right.val = tm;
                updateTreeNode(root.right);

            } else if (root.right == null) {
                int tm = root.val;
                root.val = root.left.val;
                root.left.val = tm;
                updateTreeNode(root.left);
            }
            return;
        }
        if (root.val > key) {
            dfs(root.left, key);
        } else dfs(root.right, key);
    }

    void updateTreeNode(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.val = root.left.val;
            updateTreeNode(root.left);
        } else if (root.right != null) {
            root.val = root.right.val;
            updateTreeNode(root.right);
        } else root = null;
    }
}
