package com.giangdh.graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class LeetCode743 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] times = { { 1, 2, 1 }, { 2, 3, 2 }, { 1, 3, 4 } };
		int n = 3;
		int k = 1;
		// List<List<Edges>> res = convertToAdjcentList(times, n);
		
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		System.out.println(st.pop());
		System.out.println(st.pop());
		
		System.out.println(networkDelayTime(times, n, k));

	}

	public static int networkDelayTime(int[][] times, int n, int k) {

		List<List<Edges>> res = convertToAdjcentList(times, n);

		Integer[] dist = new Integer[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = -1;
		boolean[] visited = new boolean[n + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k, 0));
		dist[k] = 0;
		Node curNode = new Node(k, 0);
		int count = 0;
		while (!pq.isEmpty()) {
			curNode = pq.poll();
			if (visited[curNode.currentNode]) {
				continue;
			}
			visited[curNode.currentNode] = true;

			for (Edges edg : res.get(curNode.currentNode)) {
				if (visited[edg.to]) {
					continue;
				}
				if (dist[edg.to] > dist[edg.from] + edg.wieght) {
					dist[edg.to] = dist[edg.from] + edg.wieght;
				}
				pq.add(new Node(edg.to, dist[edg.to]));
			}
		}
		int rss = 0;

		for (int i : dist) {
			if (i == Integer.MAX_VALUE)
				return -1;
			rss = Math.max(i, rss);
		}
		return rss;
	}

	public static List<List<Edges>> convertToAdjcentList(int[][] times, int n) {
		List<List<Edges>> res = new ArrayList<>();

		// initial
		for (int i = 0; i <= n; i++) {
			List<Edges> rs = new ArrayList<>();
			res.add(rs);
		}

		for (int i = 0; i < times.length; i++) {
			res.get(times[i][0]).add(new Edges(times[i][0], times[i][1], times[i][2]));
		}
		return res;
	}

	static class Edges {
		int from;
		int to;
		int wieght;

		public Edges(int from, int to, int wieght) {
			this.from = from;
			this.to = to;
			this.wieght = wieght;
		}
	}

	static class Node implements Comparable<Node> {
		int currentNode;
		int dist;

		public Node(int currentNode, int dist) {
			this.currentNode = currentNode;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

}
