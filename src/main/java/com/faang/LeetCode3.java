package com.faang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring2("abcc"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Integer> set = new HashSet<>();
            set.add(s.charAt(i) + 0);
            //System.out.println(s.charAt(i) + 0);
            int cnt = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j) + 0)) {
                    set.add(s.charAt(j) + 0);
                    cnt++;
                } else {
                    break;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            Map<Integer, Integer> set = new HashMap();
            set.put(s.charAt(i) + 0, i);
            int cnt = 1;
            int j = i + 1;
            boolean isFast = false;
            for (; j < s.length(); j++) {
                if (!set.containsKey(s.charAt(j) + 0)) {
                    set.put(s.charAt(j) + 0, j);
                    cnt++;
                } else {
                    i = set.get(s.charAt(j) + 0) + 1;
                    System.out.println(i);
                    isFast = true;
                    break;
                }
            }
            if (!isFast) {
                i++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        return 1;
    }
}
