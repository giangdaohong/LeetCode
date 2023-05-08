package com.giangdh.tree;

import java.util.*;

public class LeetCode2415 {
    public static void main(String[] args) {

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

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int amtAtLevel = 1 <<level;
            List<TreeNode> lst = new ArrayList<>();
            for (int i = 0; i < amtAtLevel; i++) {
                TreeNode node = queue.poll();
                if (root.left != null) {
                    lst.add(node.left);
                }
                if (root.right != null) {
                    lst.add(node.right);
                }
            }
            if (amtAtLevel % 2 == 1 && lst.size() > 0) {
                for (int i = 0, j = lst.size() - 1; i < lst.size() / 2 && j >= lst.size() / 2; i++, j--) {
                    int tmp = lst.get(i).val;
                    lst.get(i).val = lst.get(j).val;
                    lst.get(j).val = tmp;
                }
            }
            for (TreeNode tmp : lst) {
                queue.offer(tmp);
            }
            amtAtLevel++;
        }
        return root;
    }
}
