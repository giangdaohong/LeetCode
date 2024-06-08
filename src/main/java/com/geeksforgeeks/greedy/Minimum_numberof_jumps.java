package com.geeksforgeeks.greedy;

public class Minimum_numberof_jumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

		System.out.println("Number of steps :" + minJumps(arr));

	}

	static int minJumps(int[] arr) {
        
        if(arr.length == 1 && arr[0] > 0) return 0;
		if (arr[0] == 0)
			return -1;

		int idxL = 0;
		int idxR = arr[0];

		if (idxR >= arr.length - 1)
			return 1;

		int step = 1;
		//int cnt = 0;

		int minLen = idxL;
		int maxLen = idxR;
		while (idxR < arr.length) {
			step++;
			//cnt++;
			minLen = idxL;
			maxLen = idxR;

			boolean isCanJumps = false;

			for (int i = idxL; i <= idxR; i++) {
				if (arr[i] != 0)
					isCanJumps = true;

				if (i + arr[i] >= maxLen) {
					maxLen = i + arr[i];
				}
				if (i + arr[i] <= minLen) {
					minLen = i + arr[i];
				}
			}

			if (!isCanJumps)
				return -1;

			idxL = minLen;

			idxR = maxLen;
			
			if(idxR >= arr.length - 1) break;

			
		}

		//if (cnt > arr.length)
		//	return -1;

		if (step == 0)
			return -1;

		return step;
	}

}
