package com.leetcode75;

public class LC1493 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        new LC1493().longestSubarray(nums);
    }

    public int longestSubarray(int[] nums) {
        int rs = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                start = i;
                end = i + 1;
                while (end < nums.length && nums[end] == 1) {
                    end++;
                }
                System.out.println(i);
                System.out.println(end - start);
                rs = Math.max(rs, end - start);
            }
        }
        if(rs == 0) return Math.max(0, nums.length - 1);
        return rs;
    }
}
