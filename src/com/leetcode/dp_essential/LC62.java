package com.leetcode.dp_essential;

public class LC62 {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        return dfs(matrix, 0, 0, m, n);
    }

    int dfs(int[][] dp, int row, int col, int m, int n) {
        if (row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        int r = dfs(dp, row, col + 1, m, n);
        int l = dfs(dp, row + 1, col, m, n);
        dp[row][col] = r + l;
        return dp[row][col];
    }
}
