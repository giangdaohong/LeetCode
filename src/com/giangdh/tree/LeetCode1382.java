package com.giangdh.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1382 {

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1, 2, 3, 4);
        LeetCode1382 test = new LeetCode1382();
        TreeNode root = test.listToBst(lst, 0, 3);
        System.out.println("Hi there");
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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        converToList(root, res);
        return listToBst(res, 0, res.size() - 1);
    }

    void converToList(TreeNode root, List<Integer> res) {
        if (root == null) return;
        converToList(root.left, res);
        res.add(root.val);
        converToList(root.right, res);
    }

    TreeNode listToBst(List<Integer> lst, int start, int end) {
        if (start > end) return null;
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(lst.get(mid));
        root.left = listToBst(lst, start, mid - 1);
        root.right = listToBst(lst, mid + 1, end);
        return root;
    }

}
