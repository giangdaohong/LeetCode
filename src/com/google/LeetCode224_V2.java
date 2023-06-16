package com.google;

public class LeetCode224_V2 {

    public static void main(String[] args) {
        System.out.println(new LeetCode224_V2().calculate("(7) + 1"));
    }

    private int index = 0;

    /**
     * Require : String s is valid input*
     *
     * @param s
     * @return
     */


    public int calculate(String s) {
        return calculate(s.trim().toCharArray());
    }

    private int calculate(char[] expr) {
        int num = 0;
        int sum = 0;
        char prevOperand = '+';

        if (expr[index] == '-') {
            prevOperand = expr[index++];
        }

        for (; index < expr.length; ++index) {
            char c = expr[index];
            if (c >= '0' && c <= '9')
                num = num * 10 + (c - '0');
            if (c == '(') {
                ++index;
                if (prevOperand == '+')
                    sum += calculate(expr);
                else
                    sum -= calculate(expr);
            } else if (index == expr.length - 1 || c == '+' || c == '-' || c == ')') {
                if (prevOperand == '+')
                    sum += num;
                else
                    sum -= num;

                if (c == ')')
                    break;

                num = 0;
                prevOperand = c;
            }
        }

        return sum;
    }

}
