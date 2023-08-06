package com.giangdh.greedy;

import java.util.Arrays;

public class LeetCode581 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        new LeetCode581().findUnsortedSubarray(nums);
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        boolean isI = true;
        boolean isJ = true;
        while (j >= 0 && isJ || i < len && isI) {
            if (nums[j] != tmp[j] && isJ) {
                isJ = false;
            } else if (isJ) {
                j--;
            }
            if (nums[i] != tmp[i] && isI) {
                isI = false;
            } else if (isI) {
                i++;
            }
            if (i + 1 == j || i == j) {
                if (nums[i] != tmp[i]) return 2;
                else return 0;
            }
        }
        if (j == -1 || i == len) return 0;
        return j - i + 1;
    }
}
