package com.leetcode.bitwiseoper;

public class LC338 {
    public static void main(String[] args) {

    }
    public int[] countBits(int n) {
        int [] rs = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = i;
            int cnt = 0;
            while(idx >= 0) {
                if((idx & 1) == 1) {
                    cnt ++;
                }
                idx = i/2;
            }
            rs[i] = cnt;
        }

        return rs;
    }
    /**
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     * 6 --> 110
     * 7 --> 111
     * 8 --> 1000
     * 
     * 
     * 100 --> 1100100
     */
}
