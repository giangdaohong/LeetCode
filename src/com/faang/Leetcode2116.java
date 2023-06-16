package com.faang;

public class Leetcode2116 {
    public static void main(String[] args) {

    }

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1)
            return false;

        boolean isValid = validParentheses(s);

        if (isValid)
            return true;
        return true;
    }

    boolean validParentheses(String s) {
        int open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (close > open) {
                open++;
            }
        }
        if (close != open) {
            return false;
        }
        return true;
    }
}
