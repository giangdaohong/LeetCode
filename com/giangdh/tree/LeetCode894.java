package com.giangdh.tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode894 {

	public static void main(String[] args) {
		System.out.println("Hello world The testing is beginning");

	}

	// 5 => 1 3; 3;1   11 => 1, 9; 3; 7; 5; 5;
	public List<TreeNode> allPossibleFBT(int n) {
		if (n >> 1 == 0) {
			return new ArrayList<>();
		}
		List<TreeNode> rs = new ArrayList<>();
		TreeNode [] dp = new TreeNode [n];
		rs = allPossibleFBT(n, dp);
		return rs;
	}

	private List<TreeNode> allPossibleFBT(int n, TreeNode [] dp) {

		List<TreeNode> rs = new ArrayList<>();

		if(n == 1) {
			rs.add(new TreeNode(0));
			return rs;
		}
		if (dp[n] != null) {
			rs.add(dp[n]);
			return rs;
		}

		// n always is odd => n-1 is even

		// 1 and n-2; 3 and n-4; 5 and n-6; respectively number of left or right on tree

		for (int i = 1, j = n-2; i <= n - 2 && j >= 1; i +=2, j -= 2) {

			List<TreeNode> lstLeft = allPossibleFBT(i,dp);
			List<TreeNode> lstRight = allPossibleFBT(j,dp);

			for (TreeNode left: lstLeft) {
				for (TreeNode right: lstRight) {
					TreeNode root = new TreeNode(0);
					root.left = left;
					root.right = right;
					rs.add(root);
				}
			}
		}
		return rs;
	}

	/**
	 * Definition for a binary tree node.
	 *
	 * @author daohonggiang
	 *
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
