package com.google;

import java.util.Stack;

public class Leetcode227 {

    public static void main(String[] args) {
        System.out.println(new Leetcode227().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    int it = 0;
    public int calculate(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        Character sign = '+';
        while (it < s.length()) {
            if (s.charAt(it) >= '0' && s.charAt(it) <= '9') {
                num = num * 10 + (s.charAt(it) - '0');
            } else if (s.charAt(it) == '+' || s.charAt(it) == '-' || s.charAt(it) == '*' || s.charAt(it) == '/') {
                update(sign, num, stack);
                num = 0;
                sign = s.charAt(it);
            } else if (s.charAt(it) == '(') {
                num = calculate(s.substring(it + 1));
            } else if (s.charAt(it) == ')') {
                update(sign, num, stack);
            }
            it += 1;
        }
        update(sign, num, stack);
        return sum(stack);
    }

    private int sum(Stack<Integer> stack) {
        int sum = 0;
        while (stack.size() > 0) {
            sum += stack.pop();
        }
        return sum;
    }

    void update(Character op, int v, Stack<Integer> stack) {
        if (op == '+') stack.push(v);
        if (op == '-') stack.push(-v);
        if (op == '*') stack.push(stack.pop() * v);
        if (op == '/') stack.push(stack.pop() / v);
    }
}
