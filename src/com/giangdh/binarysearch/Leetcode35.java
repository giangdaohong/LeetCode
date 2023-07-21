package com.giangdh.binarysearch;

public class LeetCode35 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int target = 2;

		System.out.println(searchInsert(nums, target));
	}

	public static int searchInsert(int[] nums, int target) {

		if (nums.length == 1) {
			return 0;
		}

		int start = 0;
		int end = nums.length;
		int mid = (start + end) / 2;
		while (start < end) {
			mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (mid == start || mid == end) {
				break;
			}

			if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (mid == start)
			return start + 1;
		return end;

	}

}
