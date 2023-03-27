package com.giangdh.tree;

public class LeetCode222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	class Solution {
		public int countNodes(TreeNode root) {
			if (root == null)
				return 0;
			return 1 + countNodes(root.left) + countNodes(root.right);

		}
	}

}
