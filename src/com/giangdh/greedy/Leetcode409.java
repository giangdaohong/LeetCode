package com.giangdh.greedy;

import java.util.HashMap;
import java.util.Map;

public class Leetcode409 {

    public int longestPalindrome(String s) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i) - 1, map.getOrDefault(s.charAt(i) - 1, 0) + 1);
        }
        int cntEven = 0;
        int cntOld = 0;
        boolean first = false;
        for (int val : map.values()) {
            if (val % 2 == 0) {
                cntEven += val;
            } else {
                if (!first) {
                    cntOld += val;
                    first = true;
                } else {
                    cntOld += val - 1;
                }

            }
        }
        return cntEven + cntOld;
    }
}
