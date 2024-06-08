package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LC253 {
    public static void main(String[] args) {

        int [][] test = {{6,15},{13,20},{6,17}};

        // {{1,5},{8,9},{8,9}};

        // {{7,10},{2,4}};
        //{{5,8},{6,8}};
        //{{7,10},{2,4}};
        //{{5,8},{6,8}};
        // {{2,7}};
        //{{7,10},{2,4}};
                //= {{5,10},{15,20},{0,30}};
        System.out.println(minMeetingRooms(test));

    }

    public static int minMeetingRooms(int[][] intervals) {

        {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
        /*for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                //System.out.println(intervals[i][j]);
            }
        }*/

            int rs = 1;
            for (int i = 1; i < intervals.length; i++) {
                int current = 1;
                for(int j = 0; j < i; j++){
                    if (intervals[j][1] > intervals[i][0]) {
                        current++;
                    }
                }
                if(i == 1 && current == 1) current = 2;

                rs = Math.max(rs,current);
            }

            return rs;
        }
    }
}
