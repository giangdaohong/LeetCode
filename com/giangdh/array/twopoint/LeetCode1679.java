package com.giangdh.array.twopoint;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1679 {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2 };
		int k = 3;
		int res = new LeetCode1679().maxOperations(nums, k);
		System.out.println("End game :" + res);
	}

	public int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (i >= k)
				continue;
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int res = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			// case one
			if (k == 2 * key && val >= 2) {
				while (val >= 2) {
					res++;
					val -= 2;
				}
				map.put(key, val);
				continue;
			}

			if (k - key < 0)
				continue;

			// case two
			if (val > 0 && k - key != key && map.containsKey(k - key)) {
				Integer valRemain = map.get(k - key);
				while (val > 0 && valRemain > 0) {
					res++;
					val -= 1;
					valRemain -= 1;
				}
				map.put(key, val);
				map.put(k - key, valRemain);
			}
		}
		return res;
	}
}
