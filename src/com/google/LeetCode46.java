package com.google;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new LeetCode46().permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return rs;
    }

    List<List<Integer>> rs = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public void permute(int[] nums, int s) {
        if (s > nums.length - 1) {
            rs.add(new ArrayList<>(cur));
        }
        for (int i = s; i < nums.length; i++) {
            cur.add(nums[i]);
            swap(nums, s, i);
            permute(nums, s + 1);
            cur.remove(cur.size() - 1);
            swap(nums, s, i);
        }
    }

    void swap(int[] nums, int s, int e) {
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
}
