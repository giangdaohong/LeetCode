package com.geeksforgeeks.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Fractional_Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Function to get the maximum total value in the knapsack.
	double fractionalKnapsack(int W, Item arr[], int n) {

		Arrays.sort(arr, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				double rs = (double) o2.value / o2.weight - (double) o1.value / o1.weight;

				if (rs > 0)
					return 1;
				if (rs == 0)
					return 0;
				if (rs < 0)
					return -1;

				return 0;
			}
		});

		double res = 0;

		int i = 0;

		while (W > 0 && i < n) {
			int weiht = arr[i].weight;

			if (weiht <= W) {
				res += arr[i].value;
				W -= weiht;
				i++;
			} else {
				res += ((double) arr[i].value / (double) arr[i].weight) * W;
				W = 0;
			}
		}

		return res;
	}

	static class Item {

		int value, weight;

		Item(int x, int y) {
			this.value = x;
			this.weight = y;
		}

	}

}
