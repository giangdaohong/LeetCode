package com.faang;

/**
 * 695. Max Area of Island
 */
public class Leetcode695 {
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int x, int y) {
        int area = 1;
        grid[x][y] = Integer.MAX_VALUE;
        // go to left
        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
            area += dfs(grid, x, y - 1);
        }
        // go to right
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
            area += dfs(grid, x, y + 1);
        }
        // go to up
        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
            area += dfs(grid, x - 1, y);
        }
        // go to down
        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            area += dfs(grid, x + 1, y);
        }
        return area;
    }
}
