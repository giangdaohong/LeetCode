package com.liked100;

public class Lc48 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Lc48().rotate(matrix);
    }

    public void rotate(int[][] matrix) {

        int[][] cp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cp[i][j] = matrix[i][j];
            }
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
