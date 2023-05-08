package com.giangdh.greedy;

public class LeetCode135 {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int[] cnt = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            cnt[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                cnt[i] = cnt[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                cnt[i - 1] = Math.max(cnt[i] + 1, cnt[i - 1]);
            }
            sum += cnt[i];
        }
        return sum + cnt[0];
    }
}
