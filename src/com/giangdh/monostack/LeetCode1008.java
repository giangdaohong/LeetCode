package com.giangdh.monostack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = new int[] { 1, 3 };
		System.out.println("Hello world");
		bstFromPreorder(preorder);
		Arrays.sort(preorder);
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static TreeNode bstFromPreorder(int[] preorder) {
		List<Integer> list = Arrays.stream(preorder).boxed().collect(Collectors.toList());

		return helper(list);

	}

	public static TreeNode helper(List<Integer> lst) {
		if (lst.size() == 0)
			return null;
		TreeNode root = new TreeNode();
		List<Integer> lstLeft = getLst(lst, true);
		List<Integer> lstRight = getLst(lst, false);
		root.val = lst.get(0);
		root.left = helper(lstLeft);
		root.right = helper(lstRight);
		return root;
	}

	private static List<Integer> getLst(List<Integer> lst, boolean isLeft) {
		List<Integer> res = new ArrayList<>();

		for (int i = 1; i < lst.size(); i++) {
			if (isLeft && lst.get(i) < lst.get(0)) {
				res.add(lst.get(i));
			} else if (!isLeft && lst.get(i) > lst.get(0)) {
				res.add(lst.get(i));
			}
		}
		return res;
	}

}
