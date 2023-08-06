package com.leetcode75;

import java.util.*;

public class LC199 {


    ArrayList<Integer> rs = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> rs = new ArrayList<>();
        rs.add(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> lsTmp = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode tm = queue.poll();
                if (tm.right != null) {
                    lsTmp.add(tm.right);
                }
                if (tm.left != null) {
                    lsTmp.add(tm.left);
                }
            }
            if (!lsTmp.isEmpty()) {
                rs.add(lsTmp.get(0).val);
                queue.addAll(lsTmp);
            }
        }
        return rs;
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
