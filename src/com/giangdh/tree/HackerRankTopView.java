package com.giangdh.tree;

import java.util.Scanner;

public class HackerRankTopView {

	class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/*
	 * 
	 * class Node int data; Node left; Node right;
	 */
	public static void topView(Node root) {

		topViewLeft(root.left);
		System.out.print(root.data + " ");
		topViewRight(root.right);
	}

	public static void topViewLeft(Node root) {

		if (root == null)
			return;
		topViewLeft(root.left);
		System.out.print(root.data + " ");
	}

	public static void topViewRight(Node root) {

		if (root == null)
			return;
		System.out.print(root.data + " ");
		topViewRight(root.right);

	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new HackerRankTopView().new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		topView(root);
	}

}
