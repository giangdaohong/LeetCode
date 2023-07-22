package com.leetcode75;

import java.math.BigInteger;
import java.util.*;

public class LC437 {
    /**
     * Definition for a binary tree node.
     */
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        dfs(root, map, 0, targetSum);
        return rs;
    }

    int rs = 0;

    public void dfs(TreeNode root, Map<Long, Integer> map, long preSum, int target) {
        if (root == null) {
            return;
        }
        preSum += (long) root.val;
        if (map.containsKey(preSum - target) && map.get(preSum - target) > 0) {
            rs++;
        }
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        dfs(root.left, map, preSum, target);
        dfs(root.right, map, preSum, target);
        map.remove(preSum, map.get(preSum) - 1);
    }
}
