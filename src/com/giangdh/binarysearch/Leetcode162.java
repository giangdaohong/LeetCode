package com.giangdh.binarysearch;

public class Leetcode162 {

	public static void main(String[] args) {
		int[] nums = { 1, 2 };
		System.out.println(findPeakElement(nums));

	}

	public static int findPeakElement(int[] nums) {

		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (mid == 0) {
				if (nums[start] < nums[end]) {
					return end;
				}
				return start;
			}
			// peak element
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			}
			// halfway up the slope
			else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				start = mid + 1;
			}
			// halfway down the slope
			else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				end = mid;
			}
			// sloping bottom
			else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				start = mid + 1;
			}
		}
		return start;
	}

}
