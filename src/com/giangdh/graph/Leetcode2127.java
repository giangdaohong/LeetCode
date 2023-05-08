package com.giangdh.graph;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2127 {

	public static void main(String[] arg) {
		System.out.println("Hello world");
		int[] favorite = { 2, 2, 1, 2 };
		System.out.println(maximumInvitations(favorite));
	}

	public static int maximumInvitations(int[] favorite) {

		List<List<Integer>> lstMutal = new ArrayList<>();

		List<Integer> lstFavorite = new ArrayList<>();

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < favorite.length; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < favorite.length; i++) {
			if (favorite[favorite[i]] == i) {
				if (i < favorite[i]) {
					List<Integer> mutals = new ArrayList<>();
					mutals.add(i);
					mutals.add(favorite[i]);
					lstMutal.add(mutals);
				}
			} else {
				lstFavorite.add(i);
				graph.get(favorite[i]).add(i);
			}
		}
		return Math.max(maxCycle(lstFavorite, favorite), maxChainsMutalFavorite(favorite, graph, lstMutal));

	}

	/**
	 * @param lstFavorite []
	 * @param favorite
	 * @return the large cycle like this a->b->c...->a
	 */
	public static int maxCycle(List<Integer> lstFavorite, int[] favorite) {

		int res = 0;

		int[] counter = new int[favorite.length];
		
		for (int i : lstFavorite) {
			boolean[] visited = new boolean[favorite.length];
			int currentLength = 0;
			int count = 0;
			int j = i;
			while (!visited[favorite[j]]) {
				count++;
				counter[favorite[j]] = count;
				visited[favorite[j]] = true;
				j = favorite[j];
			}
			currentLength = count - counter[favorite[j]] + 1;

			res = Math.max(res, currentLength);

			visited = new boolean[lstFavorite.size()];
			counter = new int[favorite.length];

		}
		return res;

	}

	/**
	 * 
	 * @param favorite []
	 * @param graph
	 * @param lstMutal
	 * @return the large chains like this 1->2-3->4->(A,B)<-6<-7<-8 where (A,B)
	 *         favorite each others
	 */
	public static int maxChainsMutalFavorite(int[] favorite, List<List<Integer>> graph, List<List<Integer>> lstMutal) {
		int answer = 0;
		boolean[] visited = new boolean[favorite.length];
		Integer[] dp = new Integer[favorite.length];
		for (List<Integer> pair : lstMutal) {
			answer += dfs(graph, pair.get(0), visited, dp) + dfs(graph, pair.get(1), visited, dp);
		}
		return answer;
	}

	private static int dfs(List<List<Integer>> graph, Integer node, boolean[] visited, Integer[] dp) {
		if (dp[node] != null)
			return dp[node];
		visited[node] = true;
		int max = 0;
		for (int neighbor : graph.get(node)) {
			max = Math.max(max, dfs(graph, neighbor, visited, dp));
		}
		return dp[node] = max + 1;
	}

}
