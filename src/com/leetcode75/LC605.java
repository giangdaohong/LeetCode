package com.leetcode75;

public class LC605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		if (flowerbed.length == 1) {
			if (n == 0) {
				if (flowerbed[0] == 0) {
					return flowerbed[0] == 0 ? true : false;
				}
				return flowerbed[0] == 1 ? true : false;
			}
			return flowerbed[0] == 0 ? true : false;
		}
		for (int i = 0; i < flowerbed.length; i++) {

			if (i > 0) {
				if (flowerbed[i] == 0) {
					if (i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i - 1] == 0 // ... 0 0 0 a => 0 1 0 <=> i at 'a'
							&& flowerbed[i + 1] == 0) {
						i += 1;
						n--;
					} else if (flowerbed[i - 1] == 0 && i + 1 == flowerbed.length) {
						n--;
						i++;
					}
				}

			} else if (i == 0) {
				if (i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
					i += 1;
					n--;
				} else {
					i++;
				}
			}
		}
		return n <= 0 ? true : false;
	}

}
