package com.leetcode.binarysearch;

import java.util.Arrays;


public class LC1818 {

    public static void main(String[] args) {


        int[] num1 = new int[]{1, 7, 5};
        int[] num2 = new int[]{2, 3, 5};
        System.out.println(minAbsoluteSumDiff(num1, num2));
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        Point[] ls = new Point[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            Point p = new Point(i, nums2[i]);
            ls[i] = p;
        }
        Arrays.sort(ls);
        int total = 0;

        for (int i = 0; i < nums1.length; i++) {
            total += Math.abs(nums1[i] - nums2[i]);
        }

        int tmp = Integer.MAX_VALUE;
        int idx = 0;
        Arrays.sort(ls);

        Point rep = new Point(0, ls[0].val);
        int ans = total;
        for (int i = 0; i < ls.length; i++) {

            int num1 = nums1[i];
            int left = 0;
            int right = nums1.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;

                int mid_val = Math.abs(ls[mid].val - num1);

                if (Math.abs(ls[mid - 1].val - num1) >= mid_val && Math.abs(ls[mid + 1].val - num1) >= mid_val) {
                    if (Math.abs(num1 - ls[mid].val) < tmp && i != mid) {
                        tmp = Math.abs(num1 - ls[mid].val);
                        rep = ls[mid];
                        idx = i;
                        ans = Math.min(ans, total - (Math.abs(nums2[rep.x]) - nums1[rep.x]) + Math.abs(nums2[rep.x] - nums1[idx]));
                    }
                    break;
                }
                if (Math.abs(ls[mid - 1].val - num1) > Math.abs(ls[mid + 1].val - num1)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left == right) {
                if (Math.abs(num1 - ls[left].val) < tmp && i != left) {
                    tmp = Math.abs(num1 - ls[left].val);
                    rep = ls[left];
                    idx = i;
                    ans = Math.min(ans, total - (Math.abs(nums2[rep.x]) - nums1[rep.x]) + Math.abs(nums2[rep.x] - nums1[idx]));
                }
            }
        }
        return ans;
    }

    static class Point implements Comparable<Point> {
        int x;
        int val;

        public Point(int x, int val) {
            this.x = x;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
}
