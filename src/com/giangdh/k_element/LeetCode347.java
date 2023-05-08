package com.giangdh.k_element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LeetCode347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		new LeetCode347().topKFrequent_2(nums, k);

	}

	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> hash = new HashMap<>();

		for (int i : nums) {
			if (hash.containsKey(i)) {
				hash.put(i, hash.get(i) + 1);
			} else {
				hash.put(i, 1);
			}
		}
		Set<Entry<Integer, Integer>> entries = hash.entrySet();
		Comparator<Entry<Integer, Integer>> comparator = new Comparator<>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		};
		// sorting HashMap by values using comparator
		List<Entry<Integer, Integer>> listOfEntries = new ArrayList<Entry<Integer, Integer>>(entries);
		Collections.sort(listOfEntries, comparator);
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = listOfEntries.get(i).getKey();
		}

		return res;

	}

	public int[] topKFrequent_2(int[] nums, int k) {

		int numsMax = Integer.MIN_VALUE;
		int numsMin = Integer.MAX_VALUE;

		for (int i : nums) {
			numsMax = Math.max(numsMax, i);
			numsMin = Math.min(numsMin, i);
		}

		int[] res = new int[numsMax - numsMin + 1];
		int freqMax = 0;
		// -10 i = 1 => res[11]
		for (int value : nums) {
			res[value - numsMin]++;
			freqMax = Math.max(freqMax, res[value - numsMin]);
		}
		// Convert to list of k frequence
		List<Integer>[] lst = new ArrayList[freqMax + 1];
		for (int i = 0; i < res.length; i++) {
			if (lst[res[i]] == null) {
				lst[res[i]] = new ArrayList<>();
			}
			lst[res[i]].add(i + numsMin);
		}
		int[] re = new int[k];
		int j = 0;
		int i = freqMax;
		while (j < k) {
			if (lst[i] != null) {
				for (int num : lst[i]) {
					if (j == k)
						break;
					re[j++] = num;
				}
			}
			i--;
		}
		return re;
	}

}
