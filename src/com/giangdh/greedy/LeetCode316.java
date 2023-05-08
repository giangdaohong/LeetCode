package com.giangdh.greedy;

import java.util.*;

public class LeetCode316 {

    public static void main(String[] args) {
        String s = "abacb";
        System.out.println(new LeetCode316().removeDuplicateLetters(s));
    }


    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> frequence = new HashMap<>();
        // Count the frequency.
        for (int i = 0; i < s.length(); i++) {
            frequence.put(s.charAt(i), frequence.getOrDefault(s.charAt(i), 0) + 1);
        }
        Stack<Character> st = new Stack<>();
        Set<Character> check = new HashSet<>();
        Character first = s.charAt(0);
        st.push(first);
        frequence.put(first, frequence.get(first) - 1);
        check.add(first);
        for (int i = 1; i < s.length(); i++) {
            Character cur = s.charAt(i);
            // if cur isn't exist in checklist
            if (!check.contains(cur)) {
                // Check the Lexicographically
                // ex: s = {a, b, d, g, h, e, g, h},  st = {a, b, d, g, h, e} and
                // frequency[a] = 1, frequency[b] = 1, frequency[d] = 1,
                // frequency[g] = 2, frequency[h] = 2, frequency[e] = 2
                // at cur = 'e', current st = {a, b, d, g, h} and we have at this time st = {a, b, d, e}
                while (st.size() > 0 && cur < st.peek() && frequence.get(st.peek()) > 0) {
                    check.remove(st.pop());
                }
                st.add(cur);
                check.add(cur);
            }
            frequence.put(cur, frequence.get(cur) - 1);
        }
        StringBuilder rs = new StringBuilder();
        for (int idx = 0; idx < st.size(); idx++) {
            rs.append(st.get(idx));
        }
        return rs.toString();
    }
}
