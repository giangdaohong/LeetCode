package com.leetcode75;

public class LC1004 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(new LC1004().longestOnes(nums, 0));
    }

    public int longestOnes(int[] nums, int k) {
        int[] auxiliary = new int[nums.length];
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                auxiliary[m++] = i + 1;
            }
        }
        int rs = 0;
        m = 0;
        while (m < nums.length && auxiliary[m] > 0) {
            int cnt = k;
            int idx = auxiliary[m] - 1;
            int cntPre = 0;

            int markPre = auxiliary[m] - 2;
            while ((markPre >= 0) && nums[markPre] == 1) {
                cntPre++;
                markPre--;
            }
            idx++;
            if (k > 0) {
                while (idx < nums.length && cnt > 0) {
                    if (nums[idx] == 0) {
                        cnt--;
                    }
                    idx++;
                }
            }
            int cntSuf = 0;
            while (idx < nums.length && nums[idx] == 1) {
                cntSuf++;
                idx++;
            }
            rs = Math.max(rs, idx - auxiliary[m] + cntPre);
            m++;
        }
        return rs;
    }
}
