package com.giangdh.k_element;

public class LeetCode2310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumNumbers(int num, int k) {

		// num = 305

		// k = 5

		//

		int sum = k;

		int cnt = 0;
		for (int i = 1; i < 10; i++) {
			if (i * 10 + k == num) {
				cnt++;
				break;
			} else {
				sum += i * 10 + k;
				if (sum == num) {
					cnt++;
					break;
				}
			}
			for (int j = 1; j < 10; j++) {
				if (j * 100 + sum == num) {
					cnt++;
					break;
				} else {
					sum += j * 100;
					if (sum == num) {
						cnt++;
						break;
					}
				}
				for (int m = 1; m < 4; m++) {
					if (m * 1000 + sum == num) {
						cnt++;
						break;
					} else {
						sum += m * 1000;
						if (sum == num) {
							cnt++;
							break;
						}
					}
				}
			}
			sum = k;
		}

		return cnt + 1;

		//
	}

}
