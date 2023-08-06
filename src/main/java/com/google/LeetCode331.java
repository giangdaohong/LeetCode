package com.google;

import java.util.Collections;
import java.util.Stack;

public class LeetCode331 {
    public static void main(String[] args) {
        String pre = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        new LeetCode331().isValidSerialization(pre);
    }

    public boolean isValidSerialization(String preorder) {
        // "9,3,4,#,#,1,#,#,2,#,6,#,#"
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            while ("#".equals(cur) && st.size() > 0 && "#".equals(st.peek())) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(cur);
        }
        return st.size() == 1 && "#".equals(st.peek());
    }
}
