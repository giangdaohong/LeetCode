package com.leetcode.bitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LC2206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean divideArray(int[] nums) {
		int rs = nums[0];
		for (int i = 1; i < nums.length; i++) {
			rs ^= nums[i];
		}
		System.out.println(3 ^ 4 ^ 2 ^ 5);
		if (rs == 0)
			return true;
		return false;
	}

	public boolean divideArray2(int[] nums) {
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i : nums) {
			mp.put(i, mp.getOrDefault(i, 0) + 1);
		}
		for (Entry<Integer, Integer> et : mp.entrySet()) {
			if ((et.getValue() & 1) == 1) {
				return false;
			}
		}
		return true;
	}

}
