package com.leetcode.bitwiseoper;

public class LC1342 {

    public int numberOfSteps(int num) {
        int rs = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            rs++;
        }
        return rs;
    }
}
