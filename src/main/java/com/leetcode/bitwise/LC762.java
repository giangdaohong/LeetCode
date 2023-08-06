package com.leetcode.bitwise;

public class LC762 {
    public static void main(String[] args) {

    }

    public int countPrimeSetBits(int left, int right) {

        // 2,3,5,7,11,13,17,19
        if (left <= 0) return  0;
        int cnt = 0;
        for(int i = left; i <= right; i++) {
            int bitSet = Integer.bitCount(i);
            if(bitSet == 2 ||  bitSet == 3 || bitSet == 5 || bitSet == 7|| bitSet == 11 || bitSet == 13 || bitSet == 17 || bitSet == 19) {
                cnt++;
            }
        }

        return cnt;
    }
}
