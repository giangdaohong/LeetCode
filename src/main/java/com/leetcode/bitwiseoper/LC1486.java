package com.leetcode.bitwiseoper;

public class LC1486 {
    public static void main(String[] args) {
    }

    public int xorOperation(int n, int start) {
        int rs = start;
        for(int i = 1;i < n; i++) {
            rs ^= start + 2 * i;
        }
        return rs;
    }
}
