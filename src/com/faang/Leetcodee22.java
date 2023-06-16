package com.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcodee22 {
    public static void main(String[] args) {
        System.out.println(new Leetcodee22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        Stack<String> st = new Stack<>();
        generateParenthesis(n, 0, 0, st);
        return res;
    }
    List<String> res = new ArrayList<>();
    public void generateParenthesis(int n, int open, int close, Stack<String> st) {
        if (open == n && close == n && st.size() == 2 * n) {
            StringBuilder bd = new StringBuilder();
            for (String s : st) {
                bd.append(s);
            }
            res.add(bd.toString());
            return;
        }
        if (open < n) {
            st.push("(");
            generateParenthesis(n, open + 1, close, st);
            st.pop();
        }
        if (open > close) {
            st.push(")");
            generateParenthesis(n, open, close + 1, st);
            st.pop();
        }
    }
}
