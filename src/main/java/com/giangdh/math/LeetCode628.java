package com.giangdh.math;

import java.util.Arrays;

public class LeetCode628 {
    public static void main(String[] args) {
        int[] nums = new int[] { -8, -5, -3, 4, 7, 9, 11 };
        System.out.println(8*9*11);
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        // if maximum and minimum are same sign

        if (nums[0] * nums[nums.length - 1] >= 0) {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 2];
        }

        // if maximum and minimum are different sign
        // The array like this -8 -5 -3 4 7 9 11 or -8 -5 -3 4 7 9 or, -8 - 5 9 10
        int k = 3; // where k>=3 and nums.length >= k for any case general
        int l = 0;
        int r = nums.length - 1;

        int product = 1;

        while (k > 0) {
            if (k % 2 == 1) {
                /* take one leftmost or one rightmost firs and two rightmost or two leftmost
                 * respectively
                */ 
                if (nums[l] * nums[l + 1] > nums[r] * nums[r - 1]) {
                    product = product * nums[r--];
                    
                } else {
                    product = product * nums[l++];
                }

            } else {
                // take one leftmost or one rightmost firs and two rightmost or two leftmost
                // respectively
                if (nums[l] * nums[l + 1] > nums[r] * nums[r - 1]) {
                    product = product * nums[r--];

                } else {
                    product = product * nums[l++];
                }
            }
            k--;
        }
        return product;
    }
}
