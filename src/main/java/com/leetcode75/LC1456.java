package com.leetcode75;

public class LC1456 {
    public int maxVowels(String s, int k) {
        String t = s.substring(0, k);
        int rs = countVowel(t);
        String ch = "aeiou";
        int cnt = rs;
        if (rs == k) return k;
        // abciiidef rs = 1;
        for (int i = 1; i <= s.length() - k; i++) {
            if (ch.indexOf(s.charAt(i + k - 1)) != -1) {
                if (ch.indexOf(s.charAt(i - 1)) == -1) {
                    rs = rs + 1;
                    cnt = Math.max(cnt, rs);
                }
            } else {
                if (ch.indexOf(s.charAt(i - 1)) >= 0) {
                    rs = rs - 1;
                }
            }
            if (rs == k) return k;
        }
        return cnt;
    }

    private int countVowel(String s) {
        int cnt = 0;
        String ch = "aeiou";
        for (int i = 0; i < s.length(); i++) {
            if (ch.indexOf(s.charAt(i)) >= 0) {
                cnt++;
            }
        }
        return cnt++;
    }
}
