package com.giangdh.tree;

public class LC112 {

	public static void main(String[] args) {

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

	public boolean hasPathSum(TreeNode root, int targetSum) {

		return helperCheck(root, targetSum, 0);

	}

	public boolean helperCheck(TreeNode root, int targetSum, int cnt) {

		if (root == null) {
			return false;
		}
		if (root.val == targetSum && cnt > 0)
			return true;

		return helperCheck(root.left, targetSum - root.val, cnt++)
				|| helperCheck(root.right, targetSum - root.val, cnt++);

	}
}
