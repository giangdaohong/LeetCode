package com.leetcode.bitwise;

public class LC461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingDistance(int x, int y) {

		int z = x ^ y;
		int cnt = 0;
		while (z > 0) {
			if ((z & 1) == 1)
				cnt++;
			z >>= 1;

		}
		return cnt;
	}

}
