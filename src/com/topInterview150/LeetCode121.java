package com.topInterview150;

public class LeetCode121 {
    public static void main(String[] args) {
        int[] prices = {7, 2, 3, 5, 1, 6};
        System.out.println(new LeetCode121().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int[] max = new int[prices.length];
        int i = 0, j = prices.length - 1;

        // 7, 2, 3, 5, 1, 6
        // 7, 2, 2, 2, 1, 1
        // 7, 6, 6, 6, 6, 6


        // 7, 2, 3, 5, 1, 6

        // 7, 2, 2, 2, 1, 1
        // 6, 6, 6, 6, 6, 6
        int mi = prices[0];
        for (int k = 0; k < prices.length; k++) {
            if (mi > prices[k]) {
                mi = prices[k];
            }
            min[k] = mi;
        }

        int ma = prices[prices.length - 1];
        for (int k = prices.length - 1; k >= 0; k--) {
            if (ma < prices[k]) {
                ma = prices[k];
            }
            max[k] = ma;
        }
        int rs = 0;
        for (int k = 0; k < prices.length; k++) {
            rs = Math.max(rs, max[k] - min[k]);
        }
        return rs;

    }
}
