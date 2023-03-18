package com.giangdh.graph.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LeetCode210 {
	private static int order = 0;

	public static void main(String[] args) {
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		for (int a : findOrder(4, prerequisites)) {
			System.out.println(a);
		}
		
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] record = new int[numCourses];
		if (prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				record[i] = i;
			}
			return record;
		}
		order = numCourses;
		List<List<Edges>> lstAdjacent = convertToAdjacent(numCourses, prerequisites);
		boolean[] visited = new boolean[numCourses];
		boolean[] currentStack = new boolean[numCourses];
		int[] res = new int[0];
		for (int i = 0; i < numCourses; i++) {
			boolean isFinised = dfs(i, visited, currentStack, lstAdjacent);
			if (!isFinised) {
				return res;
			}
		}
		boolean[] reVisited = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (!reVisited[i])
				dfsRecord(i, reVisited, record, lstAdjacent);
		}
		return record;
	}

	// check if exist cycle the return false
	private static void dfsRecord(int currentNode, boolean[] reVisited, int[] record, List<List<Edges>> lstAdjacent) {
		reVisited[currentNode] = true;

		for (Edges edg : lstAdjacent.get(currentNode)) {
			if (!reVisited[edg.to]) {
				dfsRecord(edg.to, reVisited, record, lstAdjacent);
			}
		}
		record[--order] = currentNode;

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
