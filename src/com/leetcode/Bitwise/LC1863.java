package com.leetcode.Bitwise;

import java.util.ArrayList;
import java.util.List;

public class LC1863 {
	public static void main(String[] args) {
//		int x = 10;
//
//		System.out.println(x ^ 5);
//
//		// 1010 ^ 11 = 1001
//		// 1001 ^ 11 = 1010
//		System.out.println(x ^ 5 ^ 5);
		System.out.println(0 ^ 4);
		int[] nums = new int[] { 1, 3 };
		System.out.println(new LC1863().subsetXORSum(nums));

	}

	public int subsetXORSum(int[] nums) {
		back_tracking(nums, 0);
		return sum;
	}
	int sum = 0;
	int rs = 0;
	public void back_tracking(int[] nums, int start) {

		if (start >= nums.length) {
			sum += rs;
			return;
		}

		// take this one
		rs ^= nums[start];
		back_tracking(nums, start + 1);
		rs ^= nums[start];

		// by pass this one
		back_tracking(nums, start + 1);

	}

}
