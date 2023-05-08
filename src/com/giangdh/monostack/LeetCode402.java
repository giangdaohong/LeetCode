package com.giangdh.monostack;

import java.util.Stack;

public class LeetCode402 {

	public static void main(String[] args) {
		String num = "1234567890";
		// 111 ; 3
		int k = 9;

		System.out.println(removeKdigits(num, k));
		System.out.println("k = " + k);

	}

	public static String removeKdigits(String num, int k) {
		if (num.equals(""))
            return "0";
        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while (!st.isEmpty() && k > 0 && num.charAt(i) < st.peek()) {
                st.pop();
                k--;
            }
			st.push(num.charAt(i));
        }
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character tmp : st) {
            sb.append(tmp);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.toString().equals("")) {
            return "0";
        }
            
        return sb.toString();
	}
}
