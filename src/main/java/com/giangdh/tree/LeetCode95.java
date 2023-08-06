package com.giangdh.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search
 * trees), which has exactly n nodes of unique values from 1 to n. Return the
 * answer in any order. Example 1: Input: n = 3 Output:
 * [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2: Input: n = 1 Output: [[1]] Constraints: 1 <= n <= 8
 */
public class LeetCode95 {

	public static void main(String[] args) {
		List<TreeNode> res = new LeetCode95().generateTrees(3);
		System.out.println("End game");
	}

	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> rs = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			// with "i" is rooted tree
			List<TreeNode> lstLeftNode = helper(start, i - 1);
			List<TreeNode> lstRightNode = helper(i + 1, end);

			for (TreeNode leftNode : lstLeftNode) {
				for (TreeNode rightNode : lstRightNode) {
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					root.right = rightNode;
					rs.add(root);
				}
			}
			System.out.println("break");
		}
		return rs;
	}

	public List<TreeNode> helper(int start, int end) {
		List<TreeNode> rs = new ArrayList<>();
		if (start > end) {
			rs.add(null);
			return rs;
		}
		rs.addAll(generateTrees(start, end));
		return rs;
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

}
