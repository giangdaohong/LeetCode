package com.google;

import java.util.*;

public class LeetCode90 {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        new LeetCode90().subsetsWithDup(nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        backtrack(nums, 0, nums.length, lst, set);
        List<List<Integer>> rs = new ArrayList<>();
        for (List<Integer> ls : set) {
            rs.add(new ArrayList<>(ls));
        }
        return rs;
    }

    void backtrack(int[] nums, int idx, int n, List<Integer> lst, Set<List<Integer>> res) {
        if (idx >= n) {
            res.add(lst);
            return;
        }
        lst.add(nums[idx]);
        backtrack(nums, idx + 1, n, lst, res);
        lst.remove(lst.size() - 1);
        backtrack(nums, idx + 1, n, lst, res);
    }
}
