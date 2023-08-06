package com.topInterview150;

public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0, 0, 0};
        int m = 2;
        int[] nums2 = {3, 4, 5};
        int n = 3;
        new LeetCode88().merge2(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] tm = new int[m + n];

        int k = m > n ? m : n;
        int x = 0, y = 0;
        int z = 0;
        while (x < m && y < n) {
            if (nums1[x] < nums2[y]) {
                tm[z++] = nums2[y];
                y++;
            } else {
                tm[z++] = nums1[x];
                x++;
            }
        }
        if (m + n >= 0) System.arraycopy(tm, 0, nums1, 0, m + n);
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
