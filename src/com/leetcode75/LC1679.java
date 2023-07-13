package com.leetcode75;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LC1679 {
    public static void main(String[] args) {
        //int[] nums = new int[]{1, 7, 2, 6, 3, 5, 4, 4, 1, 2, 4, 4, 4, 4, 3, 4};
        int[] nums = new int[]{3, 5, 1, 5};
        int k = 2;
        System.out.println(new LC1679().maxOperations(nums, k));
    }

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, AtomicInteger> numbers = new HashMap<Integer, AtomicInteger>();
        int operations = 0;
        AtomicInteger value, complement;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                continue;
            } else {
                complement = numbers.get(k - nums[i]);
                if (complement != null && complement.get() != 0) {
                    complement.getAndDecrement();
                    operations++;
                } else {
                    value = numbers.get(nums[i]);
                    if (value != null) {
                        value.getAndIncrement();
                    } else {
                        numbers.put(nums[i], new AtomicInteger(1));
                    }
                }
            }
        }

        return operations;
    }
}
