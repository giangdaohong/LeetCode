package com.leetcode.Bitwise;

public class LC231 {
    public static void main(String[] args) {
        new LC231().isPowerOfTwo(16);
    }

    public boolean isPowerOfTwo(int n) {
        // 100000
        // 1 = 2^0
        // 10 = 2^1
        // 100 = 2^2
        // 1000 = 2^3
        // 10000 = 2^4
        if (n == 1)
            return true;
        int mask = 1;
        int cnt = 1;
        while (cnt <= 32 && mask <= n) {
            mask <<= 1;
            cnt++;
            if (n == mask)
                return true;
        }
        return false;
    }
}
