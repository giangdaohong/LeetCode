package com.giangdh.greedy;

import java.util.*;

public class LeetCode435 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        new LeetCode435().eraseOverlapIntervals(intervals);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        Map<Integer, ArrayList<Integer>> store = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            ArrayList<Integer> lst = store.getOrDefault(intervals[i][0], new ArrayList<Integer>());
            lst.add(intervals[i][1]);
            store.put(intervals[i][0], lst);
        }
        int max = 0;
        //[[1,2],[2,3],[3,4],[1,3]] => [[1,2],[2,3],[1,3], [3,4]]
        // {{0, 1}, {3, 4}, {1, 2}, {4, 5}} max = {1, 1, 1, 1}
        // {{0, 1}, {0, 4}, {1, 2}, {4, 5}}
        //
        int[] dp = new int[100002];
        for (Map.Entry<Integer, ArrayList<Integer>> keyVal : store.entrySet()) {
            for (Integer val : keyVal.getValue()) {
                max = Math.max(max, 1 + dfs(store, val, dp));
            }
        }
        return intervals.length - max;
    }

    int dfs(Map<Integer, ArrayList<Integer>> store, int start, int[] dp) {
        if (dp[start] > 0) return dp[start];
        ArrayList<Integer> lst = store.get(start);
        int rs = 0;
        if (lst == null) return rs;
        for (Integer interval : lst) {
            rs = Math.max(rs, 1 + dfs(store, interval, dp));
        }
        dp[start] = rs;
        return rs;
    }

    /**
     * [[1,11],[11,22],[11,23], [11,24], [10,24] [2,12]]
     * [1,11], [2,12], [11,22], [12, 13], [13, 18], [1,100]
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int[] mark = intervals[0];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (mark[1] > intervals[i][0]) {

                if (mark[1] < intervals[i][1]) {
                    cnt++;
                } else if (mark[1] >= intervals[i][1]) {
                    mark = intervals[i];
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
