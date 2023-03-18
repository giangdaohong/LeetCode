package com.giangdh.graph.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Leetcode207 {

	public static void main(String[] args) {
		System.out.println("Hello world");
		// [[1,4],[2,4],[3,1],[3,2]]

		int[][] prerequisites = { { 0, 1 }, { 1, 0 } };
		System.out.println(canFinish(2, prerequisites));

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Edges>> lstAdjacent = convertToAdjacent(numCourses, prerequisites);
		boolean[] visited = new boolean[numCourses];
		boolean[] currentStack = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			boolean isFinised = dfs(i, visited, currentStack, lstAdjacent);
			if (!isFinised) {
				return false;
			}
		}
		return true;
	}
	// check if exist cycle the return false
	private static boolean dfs(int i, boolean[] visited, boolean[] currentStack, List<List<Edges>> lstAdjacent) {
		if (currentStack[i]) {
			return false;
		}
		if (visited[i]) {
			return true;
		}
		visited[i] = true;

		currentStack[i] = true;

		for (Edges edg : lstAdjacent.get(i)) {
			if (!currentStack[edg.to]) {
				dfs(edg.to, visited, currentStack, lstAdjacent);
			} else {
				return false;
			}
		}
		currentStack[i] = false;
		return true;
	}
	static List<List<Edges>> convertToAdjacent(int numCourses, int[][] prerequisites) {
		List<List<Edges>> rs = new ArrayList<>();
		// Initial list
		for (int i = 0; i < numCourses; i++) {
			List<Edges> rs1 = new ArrayList<>();
			rs.add(rs1);
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int[] edg = prerequisites[i];
			rs.get(edg[1]).add(new Edges(edg[1], edg[0]));
		}
		return rs;
	}
	static class Edges {
		public int from;
		public int to;
		public Edges(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}
