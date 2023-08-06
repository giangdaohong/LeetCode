package com.giangdh.tree;

import java.util.List;

public class LeetCode96 {
    public static void main(String[] args) {
        System.out.println("Beginning");
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        return numTress(1, n, dp);
    }

    private int numTress(int start, int end, int[] dp) {
        if (dp[end - start + 1] > 0) {
            return dp[end - start + 1];
        }
        if (start >= end) {
            return 1;
        }
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            int cntLeft = numTress(start, i - 1, dp);
            int cntRight = numTress(i + 1, end, dp);
            cnt += cntLeft * cntRight;
        }
        dp[end - start + 1] = cnt;
        return cnt;
    }
}
