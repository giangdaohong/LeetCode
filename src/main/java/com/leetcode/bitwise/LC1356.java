package com.leetcode.bitwise;

import java.util.Arrays;
import java.util.Comparator;

public class LC1356 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int in1 = 10; // 1010
		while (in1 > 0) {
			if ((in1 & 1) == 1) {
				cnt++;
			}
			in1 >>= 1;
		}
		System.out.println(cnt);

	}

	public int[] sortByBits(int[] arr) {

		Comparator<Integer> cpBit = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 == o2) return 0;
				if (countBit1(o1) == countBit1(o2)) {
					return o1 - o2;
				}
				return countBit1(o1) - countBit1(o2);
			}
		};
		
		arr = Arrays.stream(arr).
			    boxed().
			    sorted(cpBit). // sort descending
			    mapToInt(i -> i).
			    toArray();
		return arr;
	}

	private int countBit1(Integer in1) {
		int cnt = 0;
		while (in1 > 0) {
			if ((in1 & 1) == 1) {
				cnt++;
			}
			in1 >>= 1;
		}
		return cnt;
	}

}
