package com.giangdh.tree;

public class LeetCode572 {

	public static void main(String[] arg) {
		TreeNode left = new TreeNode(0);

		TreeNode root = new TreeNode(3, new TreeNode(4), new TreeNode(5));

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);

		TreeNode sub = new TreeNode(4, new TreeNode(1), new TreeNode(2));

		System.out.println(isSubtree(root, sub));

	}

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
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

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (helper(root, subRoot)) {
			return true;
		}

		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public static boolean helper(TreeNode root, TreeNode subRoot) {

		if (root == null || subRoot == null) {
			return root == null && subRoot == null;
		}

		return root.val == subRoot.val && helper(root.left, subRoot.left) && helper(root.right, subRoot.right);

	}
}