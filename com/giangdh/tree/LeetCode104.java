package com.giangdh.tree;

public class LeetCode104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

	}

	// Definition for a binary tree node.
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
