package com.giangdh.binarysearch;

public class LeetCode209 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(minSubArrayLen(15, nums));

	}

	public static int minSubArrayLen(int target, int[] nums) {

		int minLen = 1;
        boolean isExist = false;
        
		for (; minLen <= nums.length; minLen++) {
			int currentSum = 0;
	        for (int i = 0; i < minLen && minLen <= nums.length; i++) {
	            currentSum += nums[i];
	        }
			if (helpfull(target, nums, minLen, currentSum)) {
                isExist = true;
                break;
			}
		}
        if(isExist)
		    return minLen;
        return 0;
	}

	private static boolean helpfull(int target, int[] nums, int minLen, int currentSum) {
		
		int tmp = currentSum;
		
        if (currentSum >= target) {
				return true;
		}
		for (int i = 1; i + minLen <= nums.length; i++) {
			tmp = tmp + nums[i + minLen - 1] - nums[i - 1];
			if (tmp >= target) {
				return true;
			}
		}
		return false;
	}

}
