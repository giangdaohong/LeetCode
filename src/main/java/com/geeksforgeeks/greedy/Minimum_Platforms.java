package com.geeksforgeeks.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimum_Platforms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println(findPlatform(arr, dep, n));

	}

	static int findPlatform(int arr[], int dep[], int n) {

		List<Trains> lstTrain = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Trains trains = new Trains(arr[i], dep[i]);
			lstTrain.add(trains);
		}
		Collections.sort(lstTrain);

		int cnt = 0;

		int max = lstTrain.get(0).dep;

		for (int i = 1; i < n; i++) {
			// arrive same time,
			// arrive between (arrive and department of train before)
			// or arrive at train before department
			int arrTime = lstTrain.get(i).arr;

			if (arrTime > max) {
				max = Math.max(max, lstTrain.get(i).dep);
				continue;
			} 
			max = Math.max(max, lstTrain.get(i).dep);
			cnt++;

		}

		return cnt;

	}

	static class Trains implements Comparable<Trains> {

		int arr;
		int dep;

		Trains(int arr, int dep) {
			this.arr = arr;
			this.dep = dep;
		}

		@Override
		public int compareTo(Trains o) {
			if (this.arr > o.arr)
				return 1;
			if (this.arr == o.arr) {
				return this.dep - o.dep;
			}
			return 0;
		}
	}

}
