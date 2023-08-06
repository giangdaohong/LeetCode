package com.liked100;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public static void main(String[] args) {

        new LC118().generate(5);

    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        rs.add(ls);
        int id = 0;
        while (rs.size() < numRows) {
            List<Integer> tm = new ArrayList<>();
            tm.add(1);
            List<Integer> cur = rs.get(id++);
            for (int i = 1; i < cur.size(); i++) {
                tm.add(cur.get(i - 1) + cur.get(i));
            }
            tm.add(1);
            rs.add(tm);
        }
        return rs;
    }
}
