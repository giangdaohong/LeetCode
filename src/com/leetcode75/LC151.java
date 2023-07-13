package com.leetcode75;

public class LC151 {

    public static void main(String[] args) {
        String s = "a good   example";
        new LC151().reverseWords(s);
    }

    public String reverseWords(String s) {
        String [] tm = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = tm.length - 1; i >= 0; i--) {
            if("".equals(tm[i])) continue;
            sb.append(tm[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
