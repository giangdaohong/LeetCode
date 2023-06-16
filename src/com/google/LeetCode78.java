package com.google;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        new LeetCode78().subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, nums.length, lst, res);
        return res;
    }

    void backtrack(int[] nums, int idx, int n, List<Integer> lst, List<List<Integer>> res) {
        if (idx >= n) {
            res.add(new ArrayList<>(lst));
            return;
        }
        lst.add(nums[idx]);
        backtrack(nums, idx + 1, n, lst, res);
        lst.remove(lst.size() - 1);
        backtrack(nums, idx + 1, n, lst, res);
    }
}
