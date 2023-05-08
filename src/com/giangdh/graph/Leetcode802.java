package com.giangdh.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode802 {

	public static void main(String[] args) {
		// [[1,2],[2,3],[5],[0],[5],[],[]]

		int[][] graph = { { 0 }, { 2, 3, 4 }, { 3, 4 }, { 0, 4 }, {} };

		for (int ab : eventualSafeNodes(graph)) {
			System.out.println(ab);
		}
	}

	public static List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> res = new ArrayList<>();
		if (graph == null || graph.length == 0)
			return res;

		int nodeCount = graph.length;
		int[] color = new int[nodeCount];

		for (int i = 0; i < nodeCount; i++) {
			if (dfs(graph, i, color))
				res.add(i);
		}

		return res;
	}

	public static boolean dfs(int[][] graph, int start, int[] color) {
		if (color[start] != 0)
			return color[start] == 1;

		color[start] = 2;
		for (int newNode : graph[start]) {
			if (!dfs(graph, newNode, color))
				return false;
		}
		color[start] = 1;

		return true;
	}
}
