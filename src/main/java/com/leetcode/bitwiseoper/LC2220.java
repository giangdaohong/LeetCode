package com.leetcode.bitwiseoper;

public class LC2220 {
    public static void main(String[] args) {

    }

    public int minBitFlips(int start, int goal) {
        // 1010 and 0111
        // x ^ y = 1010 ^ 0111 = 1101
        int x = start ^ goal;
        int rs = 0;
        while (x > 0) {
            if ((x & 1) == 1) {
                rs++;
            }
            x >>= 1;
        }
        return rs;
    }
}
