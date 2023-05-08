package com.giangdh.sliddingwindows;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode658 {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 1, 1, 2, 3, 6, 7, 8, 9 };
		int k = 9, x = 4;
		new LeetCode658().findClosestElements(arr, k, x);

	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		int lo = 0;
		int hi = arr.length - 1;
		while (hi - lo >= k) {
			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
				lo++;
			} else {
				hi--;
			}
		}
		List<Integer> result = new ArrayList<>(k);
		for (int i = lo; i <= hi; i++) {
			result.add(arr[i]);
		}
		return result;
	}

}
