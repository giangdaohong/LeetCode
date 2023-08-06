package com.faang;

import java.util.*;

public class Leetcode128 {

    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x: nums) {
            set.add(x);
        }
        int best = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int y = nums[i] + 1;
                while (set.contains(y)) {
                    y += 1;
                }
                best = Math.max(best, y - nums[i]);
            }
        }
        return  best;
    }
}
