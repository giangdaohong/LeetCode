package com.leetcode75;

import java.util.Stack;

public class LC2390 {

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ('*' == s.charAt(i) && sb.length() > 0) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
