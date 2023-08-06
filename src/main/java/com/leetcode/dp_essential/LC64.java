package com.leetcode.dp_essential;

public class LC64 {
    public int minPathSum(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];
        return dfs(grid, matrix, 0, 0, grid.length, grid[0].length);
    }

    private int dfs(int[][] grid, int[][] matrix, int row, int col, int m, int n) {
        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }
        if (row == m && col == n) {
            return grid[row][col];
        }

        if (matrix[row][col] > 0) {
            return matrix[row][col];
        }
        int r = grid[row][col] + dfs(grid, matrix, row + 1, col, m, n);
        int d = grid[row][col] + dfs(grid, matrix, row, col + 1, m, n);
        matrix[row][col] = Math.min(r, d);
        return matrix[row][col];
    }
}
