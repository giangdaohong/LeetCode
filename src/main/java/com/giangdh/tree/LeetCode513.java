package com.giangdh.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class LeetCode513 {

	public static void main(String[] args) {
		LeetCode513.TreeNode n1 = new LeetCode513().new TreeNode(1);

		n1.left = new LeetCode513().new TreeNode(2);
		n1.left.left = new LeetCode513().new TreeNode(3);
		n1.left.left.left = new LeetCode513().new TreeNode(4);
		n1.left.left.left.left = new LeetCode513().new TreeNode(5);

		n1.right = new LeetCode513().new TreeNode(6);
		n1.right.right = new LeetCode513().new TreeNode(7);
		n1.right.right.right = new LeetCode513().new TreeNode(9);
		n1.right.right.right.right = new LeetCode513().new TreeNode(10);

		travelTree(n1);
	}

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void travelTree(TreeNode root) {

		if (root == null)
			return;

		
		travelTree(root.left);
		System.out.println(root.val);
		travelTree(root.right);
		
		
		
		
		
		
	}

	static int max = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;

	}

	private static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);

		max = Math.max(max, leftMax + rightMax);

		return 1 + Math.max(leftMax, rightMax);
	}
}
