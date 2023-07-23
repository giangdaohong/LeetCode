package com.giangdh.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        new LeetCode452().findMinArrowShots(points);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int rs = 1;
        int min = points[0][0];
        int max = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][1] <= max) {
                min = points[i][0];
                max = points[i][1];
            } else if (points[i][0] < max && points[i][1] >= max) {
                min = points[i][0];
            } else if (points[i][0] >= min && points[i][1] <= max) {
                min = points[i][0];
                max = points[i][1];
            } else if (points[i][0] > max) {
                min = points[i][0];
                max = points[i][1];
                rs++;
            }
        }
        return rs;
    }
}
