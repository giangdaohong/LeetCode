package com.giangdh.binarysearch;

public class Leetcode33 {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        int[] nums = {1, 3};
        System.out.println(search(nums, 1));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[start] == target) {
                return start;
            }
            if (nums[mid] == target) {
                return mid;
            }
            // mid > start
            if (nums[mid] > nums[start]) {
                // case target in fist half
                if (target > nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // case target in fist half
                if (target > nums[start] || target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        return -1;
    }
}
