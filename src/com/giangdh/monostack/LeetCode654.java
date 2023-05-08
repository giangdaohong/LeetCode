package com.giangdh.monostack;

public class LeetCode654 {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1, 6, 0, 5 };
		constructMaximumBinaryTree(nums);

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

	/**
	 * Input: nums = [3,2,1,6,0,5] Output: [6,3,5,null,2,0,null,null,1] Explanation:
	 * The recursive calls are as follow: - The largest value in [3,2,1,6,0,5] is 6.
	 * Left prefix is [3,2,1] and right suffix is [0,5]. - The largest value in
	 * [3,2,1] is 3. Left prefix is [] and right suffix is [2,1]. - Empty array, so
	 * no child. - The largest value in [2,1] is 2. Left prefix is [] and right
	 * suffix is [1]. - Empty array, so no child. - Only one element, so child is a
	 * node with value 1. - The largest value in [0,5] is 5. Left prefix is [0] and
	 * right suffix is []. - Only one element, so child is a node with value 0. -
	 * Empty array, so no child.
	 * 
	 * @param nums
	 * @return Treemax
	 */
	public static TreeNode constructMaximumBinaryTree(int[] nums) {

		return helper(nums, 0, nums.length - 1);
	}

	public static TreeNode helper(int[] nums, int start, int end) {

		if (end < 0 || start > end) {
			return null;
		}

		int maxIdx = getMax(nums, start, end);

		TreeNode root = new TreeNode();
		root.val = nums[maxIdx];
		root.left = helper(nums, start, maxIdx - 1);
		root.right = helper(nums, maxIdx + 1, end);
		return root;
	}

	public static int getMax(int[] nums, int start, int end) {

		int maxIdx = start;
		int maxValue = nums[maxIdx];
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
}
