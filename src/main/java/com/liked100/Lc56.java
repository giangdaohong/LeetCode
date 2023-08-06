package com.liked100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc56 {
    public static void main(String[] args) {
        int[][] intervals = {{2, 6}, {1, 7}, {3, 10}, {15, 18}};
        new Lc56().merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[o1.length - 1] > o2[o2.length - 1]) {
                    return 1;
                } else if (o1[o1.length - 1] < o2[o2.length - 1]) {
                    return -1;
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> fist = new ArrayList<>();
        fist.add(intervals[0][0]);
        fist.add(intervals[0][1]);
        res.add(fist);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] pre = intervals[i - 1];
            if (cur[0] <= pre[1]) {
                int start = 0, end = 0;
                start = Math.min(cur[0], pre[0]);
                end = cur[1];
                while (!res.isEmpty()) {
                    List<Integer> tm = res.get(res.size() - 1);
                    if (tm.get(1) >= start) {
                        start = Math.min(start, tm.get(0));
                        res.remove(res.size() - 1);
                    } else {
                        break;
                    }
                }
                List<Integer> ls = new ArrayList<>();
                ls.add(start);
                ls.add(end);
                res.add(ls);
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(cur[0]);
                ls.add(cur[1]);
                res.add(ls);
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }
        return result;
    }
}
