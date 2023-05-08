package com.giangdh.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1710 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1710().maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}}, 10));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int rs = 0;
        int numsOfBox = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            while (boxTypes[i][0] > 0 && numsOfBox + boxTypes[i][0] > truckSize) {
                boxTypes[i][0]--;
            }
            numsOfBox += boxTypes[i][0];
            rs += boxTypes[i][0] * boxTypes[i][1];
        }
        return rs;
    }
}
