package com.google;

import java.util.Stack;

public class LeetCode224 {

    public static void main(String[] args) {
        System.out.println(new LeetCode224().calculate("- (3 + (4 + 5))"));
    }

    /**
     * Require : String s is valid input.
     * *************************** push hết vào stack xong rồi đọc ngược lại ***************************
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (s.charAt(i) == ')') {
                int res = 0;
                int cnt = 0;
                while (st.size() > 0 && cnt < 2) {
                    String peek = st.peek();
                    if ("(".equals(peek) && cnt == 1) {
                        break;
                    }
                    if ("(".equals(peek)) {
                        st.pop();
                        cnt++;
                        continue;
                    }
                    String cur = st.pop();
                    if ("+".equals(cur)) {
                        if (st.size() > 0) {
                            res += Integer.valueOf(st.pop());
                        }
                    } else if ("-".equals(cur)) {
                        if (st.size() > 0) {
                            try {
                                res = -res + Integer.valueOf(st.pop());
                            } catch (Exception ex) {
                                res = -res;
                            }
                        } else {
                            res = -res;
                        }
                    } else {
                        res += Integer.valueOf(cur);
                    }
                }
                st.push(String.valueOf(res));
                i++;
            } else {
                int start = i;
                int end = i + 1;
                boolean isOperator = s.charAt(start) == '+' || s.charAt(start) == '-';
                boolean isNumber = s.charAt(start) != '(' && s.charAt(start) != ')' && s.charAt(start) != '+' && s.charAt(start) != '-' && s.charAt(i) != ' ';
                if (isOperator || isNumber) {
                    while (end < s.length() && s.charAt(end) != '(' && s.charAt(end) != ')' && s.charAt(end) != '+' && s.charAt(end) != '-') {
                        end++;
                    }
                }
                st.push(s.substring(start, end).replaceAll(" ", ""));
                i = end;
            }
        }

        int res = 0;
        int idx = 0;

        while (idx < st.size()) {
            res += Integer.valueOf(st.get(idx++));
        }
        return res;
    }
}
