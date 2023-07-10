package com.geeksforgeeks.bitmagic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonRepeatingNumbers {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 4, 4, 3 };
		new NonRepeatingNumbers().singleNumber(arr);

		int x  = 10; // 1010 // x - 1 = 1001 // x + 1 = 1011
		int y = x | (x + 1);
		System.out.println("NonRepeatingNumbers.main() :" + y);
	}

	public List<Integer> singleNumber(int[] nums) {
		// 1, 2, 3, 2, 1, 4
		// 1, 2, 2, 4, 4, 3
		int n = nums.length;
		Arrays.sort(nums);

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n - 1; i = i + 2) {
			if (nums[i] != nums[i + 1]) {
				ans.add(nums[i]);
				i = i - 1;
			}
		}
		System.out.println("Hello world");
		if (ans.size() == 1)
			ans.add(nums[n - 1]);

		return ans;
		// Code here
	}
}
