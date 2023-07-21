package com.codeforces;

public class TestMain {
    public static void main(String[] args) {
        int n = 5034343;
        int i = (int) (Math.log(n) / Math.log(2));
        System.out.println(i);
        while (n > 0) {
            if (n >= 1 << i) {
                n -= (1 << i);
                System.out.println("Add : 2^i " + i + ": " + (1 << i));
            }
            i--;
        }
    }
}
