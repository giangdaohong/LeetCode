package com.leetcode.bitwise;

public class LC693 {

    public boolean hasAlternatingBits(int n) {
        int i = (int) (Math.log(n)/Math.log(2));
        while (i <= 32) {
            if( (((n >> i) & 1) ^ ( (n >> (i+1)) & 1) )  == 0 )  {
                return  false;
            }
            i++;
        }
        return true;
    }
}
