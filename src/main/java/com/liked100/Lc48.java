package com.liked100;

public class Lc48 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Lc48().rotate(matrix);
    }

    public void rotate(int[][] matrix) {

        int[][] cp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, cp[i], 0, matrix[0].length);
        }
        int curcl = matrix[0].length - 1;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][curcl] = cp[j][i];
            }
            curcl--;
        }
    }
}
