package com.giangdh.tree;

public class LeetCode98 {

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
    int preLeft = Integer.MIN_VALUE;
    int preRight = Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean isLeft = isValidBST(root.left);
        boolean isRight = isValidBST(root.right);
        if (root.right != null && root.val >= root.right.val) return false;
        if (root.left != null && root.val <= root.left.val) return false;
        return isLeft && isRight;
    }
}
