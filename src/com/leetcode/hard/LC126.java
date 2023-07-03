package com.leetcode.hard;

public class LC126 {
    public static void main(String[] args) {
        String version = System.getProperty("java.version");
        System.out.println(version);
        if (version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(".");
            if (dot != -1) {
                version = version.substring(0, dot);
            }
        }
        System.out.println(version);
    }
}
