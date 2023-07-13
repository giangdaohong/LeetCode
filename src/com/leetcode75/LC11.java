package com.leetcode75;

public class LC11 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length;

        int rs = 0;
        while (l < r) {
            rs = Math.max(rs, Math.min(height[l], height[r]) * Math.abs(height[l] - height[r]));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return rs;
    }
}
