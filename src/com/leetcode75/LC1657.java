package com.leetcode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1657 {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";

        System.out.println(new LC1657().closeStringsPro(word1, word2));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        if (word1.equals(word2)) return true;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i) - 'a', map1.getOrDefault(word1.charAt(i) - 'a', 0) + 1);
            map2.put(word2.charAt(i) - 'a', map2.getOrDefault(word2.charAt(i) - 'a', 0) + 1);
        }
        if (map1.size() != map2.size()) return false;
        // check equals key
        int[] ls1 = new int[map1.size()];
        int i1 = 0;
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            if (!map2.containsKey(entry1.getKey())) {
                return false;
            }
            ls1[i1++] = entry1.getValue();
        }
        int[] ls2 = new int[map2.size()];
        int i2 = 0;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            ls2[i2++] = entry.getValue();
        }
        Arrays.sort(ls1);
        Arrays.sort(ls2);
        for (int i = 0; i < ls1.length; i++) {
            if (ls1[i] != ls2[i]) return false;
        }
        return true;
    }

    public boolean closeStringsPro(String word1, String word2) {
        int n = word1.length();
        if (n != word2.length()) return false;
        if (word1.equals(word2)) return true;
        int freq1[] = new int['z' + 1];
        int freq2[] = new int['z' + 1];
        byte[] w = new byte[n];
        word1.getBytes(0, n, w, 0);
        for (byte c : w) {
            freq1[c]++;
        }
        word2.getBytes(0, n, w, 0);
        for (byte c : w) freq2[c]++;

        for (int i = 'a'; i <= 'z'; i++)
            if (freq1[i] == 0 ^ freq2[i] == 0)
                return false;
        Arrays.sort(freq1, 95, 123);
        Arrays.sort(freq2, 95, 123);
        return Arrays.equals(freq1, freq2);
    }
}