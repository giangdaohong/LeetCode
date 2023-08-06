package com.giangdh.greedy;

import java.util.Arrays;

public class Leetcode334 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 4, 1, 3};
        new Leetcode334().increasingTriplet(nums);
    }

    public boolean increasingTriplet(int[] nums) {
        boolean[] dpMax = new boolean[nums.length];
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            // 1 ,2 3
            if (nums[i] < max) {
                dpMax[i] = true;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        boolean[] dpMin = new boolean[nums.length];
        int min = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > min) {
                dpMin[i] = true;
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 1; i <= nums.length - 2; i++) {
            if (dpMin[i] && dpMax[i]) return true;
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        boolean[] dpMax = new boolean[nums.length - 1];
        int max = nums[nums.length - 1];
        int i = nums.length - 2;

        boolean[] dpMin = new boolean[nums.length - 1];
        int min = nums[0];
        int j = 1;
        while (i > 0 && j < nums.length - 1) {
            if (nums[i] < max) {
                dpMax[i] = true;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[j] > min) {
                dpMin[j] = true;
            }
            if (nums[j] < min) {
                min = nums[j];
            }
            i--;
            j++;
        }
        for (int k = 1; k <= nums.length - 2; k++) {
            if (dpMin[k] && dpMax[k]) return true;
        }
        return false;
    }

    public boolean increasingKnumber(int[] nums, int k) {
        int[] track = new int[k];
        Arrays.fill(nums, Integer.MAX_VALUE);
        for (int n : nums) {
            int m = 0;
            boolean isExist = true;
            while (m < k) {
                if (track[m++] >= nums[n]) {
                    isExist = false;
                    break;
                }
            }
            if (isExist) return true;
        }
        return true;
    }
}
