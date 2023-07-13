package com.leetcode75;

public class LC238 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        new LC238().productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pr = new int[len];
        int[] suf = new int[len];

        int l = 1;
        int r = len - 2;
        pr[0] = 1;
        suf[len - 1] = 1;

        int preProduct = 1;
        int sufProduct = 1;

        while (l < len || r >= 0) {
            preProduct = preProduct * nums[l - 1];
            pr[l] = preProduct;

            sufProduct = sufProduct * nums[r + 1];
            suf[r] = sufProduct;

            l++;
            r--;
        }

        int[] rs = new int[len];

        for (int i = 0; i < len; i++) {
            rs[i] = pr[i] * suf[i];
        }
        return rs;
    }
}
