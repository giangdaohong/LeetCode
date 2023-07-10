package com.leetcode.bitwiseoper;

public class LC268 {
    public static void main(String[] args) {
        int [] nums = new int[] {2,1};
        System.out.println(new LC268().missingNumber(nums));
    }
    //268. Missing Number
        public int missingNumber(int[] nums) {
            int rs = 0;
            for(int i = 0; i < nums.length; i++) {
                rs = rs^i^nums[i];
            }
            return rs^nums.length;
        }

}
