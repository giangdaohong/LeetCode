package com.leetcode75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC1161 {

    ArrayList<Integer> rs = new ArrayList<>();

    public int rightSideView(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int max = root.val;
        queue.offer(root);
        int level = 1;
        int ans = level;

        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            level++;
            while (size-- > 0) {
                TreeNode tm = queue.poll();
                if (tm.right != null) {
                    queue.offer(tm.right);
                    sum += tm.right.val;
                }
                if (tm.left != null) {
                    queue.offer(tm.left);
                    sum += tm.left.val;
                }
            }

            if (sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }


    /**
     * Definition for a binary tree node.
     */
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
}
