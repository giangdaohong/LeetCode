package com.geeksforgeeks.greedy;

public class Jump_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 1, 0, 2 };
		int N = 3;

		System.out.print(canReach(A, N));

	}

	static int canReach(int[] A, int N) {

		int i = 1;
		int idx = A[0];
		while (i < N && i <= idx) {
			idx = Math.max(idx, A[i] + i);
			i++;
		}

		return i >= N ? 1 : 0;

	}

}
