package com.sparse_table;

import java.util.Arrays;

public class LC2070 {

    public static void main(String[] args) {
        int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        // int[][] items = {{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        //int[][] items = {{193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746}, {478, 548}, {640, 908}, {210, 799}, {567, 715}, {914, 388}, {487, 853}, {533, 554}, {247, 919}, {958, 150}, {193, 523}, {176, 656}, {395, 469}, {763, 821}, {542, 946}, {701, 676}};

        int[] queries = {1, 2, 3, 4, 5, 6};
        //int[] queries = {885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479, 1180, 875, 276, 1584
        //};
        int[] rs = new LC2070().maximumBeauty(items, queries);
        System.out.println("Print result: ");
        System.out.println(Arrays.toString(rs));
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (int[] a, int[] b) -> {
            if (a[0] > b[0]) return 1;
            if (a[0] == b[0]) return a[1] - b[1];
            return -1;
        });
        System.out.println("Print items:");
        System.out.println(Arrays.deepToString(items));
        int[][] spare = sparseTable(items);
        for (int i = 0; i < queries.length; i++) {
            int l = 0;
            int r = items.length;
            while (l < r && l < items.length) {
                int mid = l + (r - l) / 2;
                if (queries[i] >= items[mid][0]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (l == items.length) {
                //TODO
            }
            System.out.println("Up bound :" + l);
            int idx = (int) (Math.log(l + 1) / Math.log(2)) + 1;
            queries[i] = Math.max(spare[0][idx - 1], spare[1 << (idx - 1)][idx - 1]);

        }
        return queries;
    }

    int[][] sparseTable(int[][] items) {
        // 0, 2, 4, 8
        int n = items.length;
        int k = (int) (Math.log(items.length) / Math.log(2)) + 1;
        System.out.format("Print sparseTable 2^%d:", k);
        int[][] spase = new int[items.length][k];
        for (int i = 0; i < n; i++) spase[i][0] = items[i][1];
        for (int j = 1; j <= k; j++) {
            for (int i = 0; (i + (1 << j)) < n; i++) {
                spase[i][j] = Math.max(spase[i][j - 1], spase[i + (1 << (j - 1))][j - 1]);
            }
        }
        System.out.println("Print sparseTable:");
        System.out.println(Arrays.deepToString(spase));
        return spase;
    }
}
