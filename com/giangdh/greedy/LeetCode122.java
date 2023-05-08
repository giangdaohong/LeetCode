package com.giangdh.greedy;

public class LeetCode122 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int [][] profit = new int[prices.length][2];
        // Buy : 0; Sell : 1
        profit[0][0] = -prices[0];
        profit[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // buy or hold
            profit[i][0] = Math.max(profit[i - 1][1] - prices[i], profit[i - 1][0]);
            // sell or hold
            profit[i][1] = Math.max(profit[i - 1][0] + prices[i], profit[i - 1][1]);
        }
        return  Math.max(profit[prices.length - 1][0], profit[prices.length - 1][1]);
    }

}
