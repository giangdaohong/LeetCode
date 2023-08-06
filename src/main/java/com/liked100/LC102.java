package com.liked100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> rs = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> lst = new ArrayList<>();
            List<Integer> lstInt = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode tm = q.poll();
                lst.add(tm);
                lstInt.add(tm.val);
            }
            rs.add(lstInt);
            for (TreeNode node : lst) {
                q.add(node.left);
                q.add(node.right);
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
