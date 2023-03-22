package com.giangdh.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode2192 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<List<Integer>> getAncestors(int n, int[][] edges) {
		List<List<Integer>> result = new ArrayList<>();
		List<List<Edges>> lstAdjancent = convertToAdjacent(n, edges);
		List<Integer> rs;
		boolean[] visited = null;
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			rs = new ArrayList<>();
			dfs(i, visited, lstAdjancent, rs);
			Collections.sort(rs);
			result.add(rs);
		}
		return result;
	}

	private static void dfs(int i, boolean[] visited, List<List<Edges>> lstAdjancent, List<Integer> rs) {
		visited[i] = true;
		for (Edges ad : lstAdjancent.get(i)) {
			if (!visited[ad.to]) {
				rs.add(ad.to);
				dfs(ad.to, visited, lstAdjancent, rs);

			}
		}
	}

	static List<List<Edges>> convertToAdjacent(int numCourses, int[][] prerequisites) {
		List<List<Edges>> rs = new ArrayList<>();
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
