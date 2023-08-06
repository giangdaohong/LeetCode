package com.leetcode.dp_essential;

public class LC63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];

        return dfs(matrix, obstacleGrid, 0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    private int dfs(int[][] matrix, int[][] obstacleGrid, int row, int col, int m, int n) {
        if (row > m || col > n || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == m && col == n) {
            return 1;
        }
        if (matrix[row][col] > 0) return matrix[row][col];
        // go right
        int r = dfs(matrix, obstacleGrid, row + 1, col, m, n);
        int d = dfs(matrix, obstacleGrid, row, col + 1, m, n);
        matrix[row][col] = r + d;
        return matrix[row][col];
    }


}
