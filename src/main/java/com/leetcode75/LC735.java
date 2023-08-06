package com.leetcode75;

import java.util.Arrays;

public class LC735 {

    public int[] asteroidCollision(int[] asteroids) {
        int[] rs = new int[asteroids.length];
        int end = 0;
        for (int tm : asteroids) {
            if (tm < 0) {
                boolean isExt = true;
                while (end - 1 >= 0 && rs[end - 1] * tm < 0) {
                    if (Math.abs(rs[end - 1]) < Math.abs(tm)) {
                        end--;
                    } else if (Math.abs(rs[end - 1]) == Math.abs(tm)) {
                        end--;
                        isExt = false;
                        break;
                    } else {
                        isExt = false;
                        break;
                    }
                }
                if (isExt) rs[end++] = tm;
            } else {
                rs[end++] = tm;
            }
        }
        return Arrays.copyOf(rs, end);
    }
}
