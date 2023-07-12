package com.leetcode.bitwise;

public class LC1009 {

    public static void main(String[] args) {
        System.out.println(new LC1009().bitwiseComplement(5));
    }

    public int bitwiseComplement(int n) {
        //                  101
        // ~n = 111111111...010
        //                  100

        // 01^10 = 11

        int tm = (int) (Math.log(n - 1) / Math.log(2));
        int tm2 = tm << 1;

        System.out.println(Integer.toBinaryString((~n) & (~tm2)));
        return (~n) & (~tm2);
    }
}
