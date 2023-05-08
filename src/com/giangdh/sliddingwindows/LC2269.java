package com.giangdh.sliddingwindows;

public class LC2269 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 430043;
		int k = 2;
		System.out.println(24 % 100);
		System.out.println(divisorSubstrings(num, k));
	}

	public static int divisorSubstrings(int num, int k) {

		// 1243545
		int cnt = 0;
		int tmp = num;
		int shifK = (int) Math.pow(10, k);
		while (tmp > 0 && tmp >= Math.pow(10, k - 1)) {
			if ((tmp % shifK) != 0 || num % (tmp % shifK) == 0) {
				cnt++;
			}
			tmp = tmp / 10;
		}

		return cnt;

	}

}
