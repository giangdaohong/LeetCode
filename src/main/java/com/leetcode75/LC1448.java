package com.leetcode75;

public class LC1448 {
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

    public int goodNodes(TreeNode root) {
        goodNodes(root.left, root.val);
        goodNodes(root.right, root.val);
        return cnt;

    }

    int cnt = 0;

    public void goodNodes(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) cnt++;
        goodNodes(root.left, Math.max(max, root.val));
        goodNodes(root.right, Math.max(max, root.val));
    }

}
