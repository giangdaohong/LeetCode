package com.giangdh.monostack;

import java.util.Stack;

public class LeetCode1673 {

	public static void main(String[] args) {
		System.out.println("Hello world");
		int[] nums = new int[] { 6, 5, 4, 3, 3, 2, 1 };
		mostCompetitive(nums, 3);
	}

	public static int[] mostCompetitive(int[] nums, int k) {
		// 6 , 5, 4, 3, 3, 2, 1 k = 3, nums.length = 6
		// 5 stack.size = 1 remain 5
		// 4 stack.size = 1 remain 4
		// 3 stack.size = 1 remain 3
		// 3 stack.size = 1 remain 2 if(k - stack.size < nums.length - ith)
		// 2 stack.size = 1 remain 1
		// 1 stack.size = 1 remain 0
		// 8, 5, 4, 6, 7 , 1 k = 3
		// 8 stack.size = 1 // remain = k - 1 = 2, yes
		// 5 stack.size = 1 // yes
		// 4
		// 4 6
		// 4 6 7
		// ==> 4 6 1
		int[] rs = new int[k];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while (!st.isEmpty() && nums[i] < st.peek() && nums.length - 1 - i >= k - st.size() ) {
				st.pop();
			}
			st.push(nums[i]);
		}
        for (int i = 0; i < rs.length; i++) {
            rs[i] = st.get(i);
        }
		return rs;
	}
}
