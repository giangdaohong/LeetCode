package com.giangdh.array.twopoint;

public class LeetCode42 {

	public static void main(String[] args) {
		int[] height = { 1, 0, 2, 1, 0, 1, 3, 2, 1, 2 };
		System.out.println(trap(height));

	}

	public static int trap(int[] height) {

		int[] dp = new int[height.length];

		int idxPreMax = 0;
		int preMax = height[0];

		for (int i = 1; i < height.length; i++) {
			if (height[i - 1] > preMax) {
				preMax = height[i - 1];
				idxPreMax = i - 1;
			}
			if (height[i] > height[i - 1]) {
				int idxxx = lastWatter(height, idxPreMax, preMax, i);
				dp[i] = dp[idxxx] + area(height, idxxx, i);
			} else {
				dp[i] = dp[i - 1];
			}
		}

		return dp[height.length - 1];
	}

	private static int lastWatter(int[] height, int idxPreMax, int preMax, int i) {

		int idxTmp = 0;

		for (int j = i - 1; j >= idxPreMax; j--) {
			if (height[j] >= height[i]) {
				idxTmp = j;
				break;
			}
		}
		if (idxTmp == 0) {
			idxTmp = idxPreMax;
		}

		return idxTmp;
	}

	private static int area(int[] height, int idxTmp, int i) {
		int sum = Math.min(height[i], height[idxTmp]);
		for (int k = idxTmp + 1; k < i; k++) {
			sum += height[k];
		}
		return Math.min(height[i], height[idxTmp]) * (i - idxTmp) - sum;
	}

}
