package com.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        boolean isSwap = false;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
                isSwap = true;
                break;
            }
        }
        if (!isSwap) {
            int i, k, t;
            for (i = 0; i < nums.length / 2; i++) {
                t = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = t;
            }
        }
    }
}
