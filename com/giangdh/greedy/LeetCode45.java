package com.giangdh.greedy;

public class LeetCode45 {

    public static void main(String[] args) {
        System.out.println(new LeetCode45().jump(new int[]{2, 1}));
    }

    public int jump2(int[] nums) {
        int maxCanReach = 0;
        int minCanReach = 0;
        int farthest = 0;
        int jump = 0;
        while (maxCanReach < nums.length - 1) {

            for (int j = minCanReach; j <= maxCanReach; j++) {
                farthest = Math.max(farthest, j + nums[j]);
            }
            minCanReach = maxCanReach + 1;
            maxCanReach = farthest;
            jump++;

        }
        return jump;
    }

    public int jump(int[] nums) {
        return jump(nums, 0);
    }

    public int jump(int[] nums, int start) {

        int j = nums[start];
        int min = 100000;

        if (start == nums.length - 1) return 0;
        if (start >= nums.length) return min;

        if (j == 0) return min;
        for (int i = 1; i <= j && start + i < nums.length; i++) {
            min = Math.min(min, 1 + jump(nums, start + i));
        }
        return min;
    }
}
