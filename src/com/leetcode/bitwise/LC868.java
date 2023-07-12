package com.leetcode.bitwise;

public class LC868 {

    public int binaryGap(int n) {
        int cnt = 0;
        int pre = 0;
        int cur = 0;
        while(n > 0) {
            if ((n & 1) == 1) {
                cnt = Math.max(cnt,cur - pre);
                pre = cur;
            } else {
                cur++;
            }
        }
        return  cnt;
    }
}
