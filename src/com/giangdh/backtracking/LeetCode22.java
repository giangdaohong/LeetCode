package com.giangdh.backtracking;

import java.util.*;

public class LeetCode22 {

    public static void main(String[] args) {
        new LeetCode22().generateParenthesis(3);
    }

    private boolean isValid(String pString) {
        int leftCount = 0;
        for (char p : pString.toCharArray()) {
            if (p == '(') {
                leftCount++;
            } else {
                leftCount--;
            }

            if (leftCount < 0) {
                return false;
            }
        }
        return leftCount == 0;
    }

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(Arrays.asList(""));

        while (!queue.isEmpty()) {
            String curString = queue.poll();
            // If the length of curString is 2 * n, add it to `answer` if
            // it is valid.
            if (curString.length() == 2 * n) {
                if (isValid(curString)) {
                    answer.add(curString);
                }
                continue;
            }
            queue.offer(curString + ")");
            queue.offer(curString + "(");
        }

        return answer;
    }

    public List<String> dfs(int n) {
        List<String> rs = new ArrayList<>();
        if (n == 0) return null;

        rs.add("(");
        List<String> rs1 = dfs(n-1);

        rs.addAll(dfs(n-1));


        return  null;

    }
}
