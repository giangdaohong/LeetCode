package com.leetcode75;

import java.util.Stack;

public class LC394 {
    public static void main(String[] args) {
        String test = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        //String test = "3[a]2[bc]";
        System.out.println(new LC394().decodeString(test));
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (!"]".equals(String.valueOf(s.charAt(i)))) { // current is not bracket close
                st.push(String.valueOf(s.charAt(i)));
            } else { // current is bracket close
                StringBuilder tmp = new StringBuilder();
                while (st.size() > 0 && !"[".equals(st.peek())) {
                    tmp.insert(0, st.pop());
                }
                StringBuilder cr = new StringBuilder();
                st.pop();
                StringBuilder number = new StringBuilder();
                while (st.size() > 0 && isNumeric(st.peek())) {
                    number.append(st.pop());
                }
                int stop = Integer.valueOf(number.reverse().toString());
                for (int j = 0; j < stop; j++) {
                    cr.append(tmp);
                }
                st.push(cr.toString());
            }

        }
        for (int i = 0; i < st.size(); i++) {
            sb.append(st.get(i));
        }
        return sb.toString();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
