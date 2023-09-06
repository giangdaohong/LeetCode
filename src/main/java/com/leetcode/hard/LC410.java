package com.leetcode.hard;

public class LC410 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 2;
		LC410 lc410 = new LC410();
		lc410.splitArray(nums, k);
		System.out.println(lc410.anw);
	}

	public int splitArray(int[] nums, int k) {
		splitArray(nums, k, 0);
		return anw;
	}

	int anw = Integer.MAX_VALUE;

	public int splitArray(int[] nums, int k, int start) {
		if (k == 0 || start >= nums.length - k + 1)
			return Integer.MAX_VALUE;
		if (k == 1) {
			int tmp = 0;
			for (int i = start; i < nums.length; i++) {
				tmp += nums[i];
			}
			return tmp;
		}

		int ans = 0;
		int tmp = 0;	

		for (int j = start; j < nums.length - k + 1; j++) {

			if (nums.length - j + 1 < k) {
				break;
			}

			int tmp1 = splitArray(nums, k, j + 1);
			
			ans += nums[j];

			int tmp2 = splitArray(nums, k - 1, j + 1);
			tmp2 = Math.max(ans, tmp2);
			anw = Math.min(tmp, tmp1);
			System.out.println(tmp);
		}
		return tmp;

	}
}
