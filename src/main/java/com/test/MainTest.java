package com.test;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        int log2N = 31 - Integer.numberOfLeadingZeros(100000);

        System.out.println("Log 1M = " + log2N);
        System.out.println("2^16 = " + String.valueOf(Math.pow(2, 15)));
        int[][][][] fourD = new int[2][2][2][2];

        fourD[0][0][0][0] = 1;

        int[][][] threeD = fourD[0];

        int[][] twoD = threeD[0];

        int[] oneD = twoD[0];

        int[][][] employee = {{{10, 20, 30}, {50, 60, 70}, {80, 90, 100}, {110, 120, 130}}, {{15, 25, 35}, {22, 44, 66}, {33, 55, 77}, {78, 57, 76}}, {{100, 101, 102}, {103, 104, 105}, {106, 107, 108}, {109, 110, 111}}};
        System.out.println(employee.length);
        for (int i = 0; i < employee.length; i++) {
            System.out.println(Arrays.deepToString(employee[i]));

            for (int j = 0; j < employee[0].length; j++) {
                int[] two = employee[i][j];
                for (int k = 0; k < two.length; k++) {
                    System.out.print((two[k]) + " ");
                }
                System.out.println();

            }

        }
    }
}
