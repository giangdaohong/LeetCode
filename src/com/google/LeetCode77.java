package com.google;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public static void main(String[] args) {
        // 1, 2, 3, 4, 5
        new LeetCode77().combine(5, 3);
    }


    public List<List<Integer>> combine(int n, int k) {
        List<Integer> lst = new ArrayList<>();
        backtrack(1, n, k, lst);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    void backtrack(int start, int n, int k, List<Integer> lst) {
        int size = lst.size();
        if (start > n || size == k) {
            if (size == k) {
                res.add(new ArrayList<Integer>(lst));
            }
            return;
        }
        if (size + n - start + 1 < k) return;
        lst.add(start);
        backtrack(start + 1, n, k, lst);
        lst.remove(lst.size() - 1);
        backtrack(start + 1, n, k, lst);
    }
}
