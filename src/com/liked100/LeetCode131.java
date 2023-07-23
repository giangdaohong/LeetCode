package com.liked100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    public static void main(String[] args) {
        String s = "aab";
        //new LeetCode131().palindrome(s, 0, 0);
        System.out.println(new LeetCode131().partition(s));
    }

    public List<List<String>> partition(String s) {
        List<String> ls = new ArrayList<>();
        backtrack(s, 0, ls);
        return rs;
    }

    List<List<String>> rs = new ArrayList<>();

    void backtrack(String s, int st, List<String> ls) {
        if (st == s.length()) {
            rs.add(new ArrayList<>(ls));
        }
        for (int i = st; i < s.length(); i++) {
            if (palindrome(s, st, i)) {
                ls.add(s.substring(st, i + 1));
                backtrack(s, i + 1, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }
    private boolean palindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}