package com.giangdh.tree;

public class LeetCode687 {
    int maxLength = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int len = findPath(root);
        return Math.max(len, maxLength);
    }

    private int findPath(TreeNode node) {
        if (node.left == null && node.right == null) return 0;
        int leftPath = 0, rightPath = 0, totalPath = 0, halfPath = 0;
        if (node.left != null) {
            leftPath = findPath(node.left);
            if (node.val == node.left.val) {
                totalPath += leftPath + 1;
                halfPath += leftPath + 1;
            }
        }
        if (node.right != null) {
            rightPath = findPath(node.right);
            if (node.val == node.right.val) {
                totalPath += rightPath + 1;
                halfPath = Math.max(halfPath, rightPath + 1);
            }
        }
        maxLength = Math.max(maxLength, totalPath);
        return halfPath;
    }

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
