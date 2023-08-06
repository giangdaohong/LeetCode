package com.giangdh.greedy;

public class LeetCode397 {
    public static void main(String[] args) {
        new LeetCode397().integerReplacement(65535);
    }

    public int integerReplacement(int n) {
        if (n == 1)
            return 1;

        int cnt = 0;
        if (n == Integer.MAX_VALUE) {
            n = Integer.MAX_VALUE -  1;
            cnt++;
        }
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else n = n + 1;
            System.out.println(n);
            cnt++;
        }
        System.out.println(cnt);
        return cnt;
    }
}
