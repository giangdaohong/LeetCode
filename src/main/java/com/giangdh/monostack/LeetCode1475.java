package com.giangdh.monostack;

public class LeetCode1475 {
    
    public static void main(String[] args) {
        
    }

    public int[] finalPrices(int[] prices) {

        int [] rs = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i] >= prices[j]) {
                    rs[i] = prices[i] - prices[j];
                    break;
                }
            }
            rs[i] = prices[i];
        }
        return rs;
    }
}
