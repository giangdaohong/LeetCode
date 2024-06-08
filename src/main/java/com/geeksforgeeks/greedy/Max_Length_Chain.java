package com.geeksforgeeks.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Max_Length_Chain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxChainLength(Pair arr[], int n) {
		// your code here

		Arrays.sort(arr, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub

				if (o1.y == o2.y)
					return o1.x - o2.x;

				return o1.y - o2.y;
			}
		});

		int rs = 1;

		int curMax = arr[0].y;

		for (int i = 1; i < n; i++) {
			if (arr[i].x > curMax) {
				curMax = arr[i].y;
				rs++;
			}
		}

		return rs;
	}

	class Pair {
		int x;
		int y;

		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}

}
