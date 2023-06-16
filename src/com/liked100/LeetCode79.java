package com.liked100;

public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int idx) {
        if (x >= board.length || x < 0) return false;
        if (y >= board[0].length || y < 0) return false;
        if (idx == word.length()) {
            return true;
        }
        boolean isRes = false;

        if (board[x][y] == word.charAt(idx) && board[x][y] != 'X') {
            char tmp = board[x][y];
            board[x][y] = 'X';
            // go right
            boolean isRight = dfs(board, x + 1, y, word, idx + 1);
            if (isRight) return true;
            // go left
            boolean isLeft = dfs(board, x - 1, y, word, idx + 1);
            if (isLeft) return true;
            // go up
            boolean isUp = dfs(board, x, y - 1, word, idx + 1);
            if (isUp) return true;
            // go down
            boolean isDown = dfs(board, x, y + 1, word, idx + 1);
            if (isDown) return true;
            board[x][y] = tmp;
        }
        return isRes;
    }

}
