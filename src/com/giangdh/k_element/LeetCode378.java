package com.giangdh.k_element;

public class LeetCode378 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int[][] matrix = { 
				{ 1, 5, 9 }, 
				{ 10, 11, 13 }, 
				{ 12, 13, 15 } };

		// 1, 5, 9, 10 11 13 12 13 15
		// 1, 2, 3, 3, 3,

		int k = 8;

		System.out.println(new LeetCode378().kthSmallest(matrix, k));
	}

	public int kthSmallest(int[][] matrix, int k) {
		return 1;
	}

}
