package com.leetcode.dp_essential;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC120 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(new Integer[]{2}));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(new Integer[]{3, 4}));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(new Integer[]{6, 5, 7}));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(new Integer[]{4, 1, 8, 3}));
        List<Integer> l5 = new ArrayList<>(Arrays.asList(new Integer[]{7, 1, 8, 3, 2}));
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(l1);
        tri.add(l2);
        tri.add(l3);
        tri.add(l4);
        tri.add(l5);
        System.out.println(new LC120().minimumTotal(tri));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         *     2 dp[0]            12
         *    3 4 dp[0-1]       10,11
         *   6 5 7 dp [0-2]    8,7,12
         *  4 1 8 3 - dp[0-3] 5,2,11,5
         * 7 1 8 3 2 dp[0-4]
         *
         * 1,
         * 2,
         * 3,
         * 4,
         * 5,
         * 6,
         *
         * dp
         */
        int si = triangle.size();
        if (si == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[si];
        int i = si - 2;
        int k = 0;
        for (int tm : triangle.get(si - 1)) {
            dp[k++] = tm;
        }
        while (i >= 0) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
            i--;
        }
        return dp[0];
    }

}

