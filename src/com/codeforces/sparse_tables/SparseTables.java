package com.codeforces.sparse_tables;

public class SparseTables {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5, 7, 1};
        System.out.println(Math.log(9)/Math.log(2));
        System.out.println(new SparseTables().RMQ1(nums, 2, 5));
        System.out.println(new SparseTables().RMQ2(nums, 2, 5));
        System.out.println(new SparseTables().RMOfficial(nums, 2, 5));
    }


    int RMOfficial(int[] nums, int L, int R) {

        int[][] sparse = preprocessOffical(nums);
        int j = (int) (Math.log(R - L + 1) / Math.log(2));

        int rs = Math.min(sparse[L][j], sparse[R - (1 << j) + 1][j]);

        return rs;
    }

    int[][] preprocessOffical(int[] nums) {
        int k = (int) (Math.log(nums.length) / Math.log(2)) + 1;
        int[][] sparse = new int[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            sparse[i][0] = nums[i];
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < nums.length; i++) {
                sparse[i][j] = Math.min(sparse[i][j - 1], sparse[i + ((j - 1) << 1)][j - 1]);
            }
        }
        for (int i = 0; i < sparse.length; i++) {
            for (int j = 0; j < sparse[0].length; j++) {
                System.out.print(sparse[i][j] + " ");
            }
            System.out.println();
        }
        return sparse;
    }

    int RMQ2(int[] nums, int L, int R) {
        int dp[][] = new int[nums.length][nums.length];
        preprocess(nums, dp);

        return dp[L][R];
    }

    void preprocess(int[] nums, int[][] dp) {
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], nums[j]);
            }
        }
    }

    int RMQ1(int[] nums, int L, int R) {
        int rs = Integer.MAX_VALUE;
        for (int i = L; i <= R; i++) {
            rs = Math.min(rs, nums[i]);
        }
        return rs;
    }
}
