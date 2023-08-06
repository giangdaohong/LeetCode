package com.liked100;

public class LeetCode153 {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(new LeetCode153().findMin(nums));
    }

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int tmp = 0;
        while (start < end) {
            if (nums[start] > nums[end]) {
                tmp = end--;
            } else {
                return nums[tmp];
            }
        }
        return nums[tmp];
    }
}
