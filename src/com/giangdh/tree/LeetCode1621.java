package com.giangdh.tree;

public class LeetCode1621 {

    public static void main(String[] args) {
        TreeNode root = new LeetCode1621().new TreeNode(-1);
        root.right = new LeetCode1621().new TreeNode(-1);
        root.left = new LeetCode1621().new TreeNode(-1);

        root.left.left = new LeetCode1621().new TreeNode(-1);
        root.left.right = new LeetCode1621().new TreeNode(-1);

        LeetCode1621 obj = new LeetCode1621(root);
        obj.find(3);

    }

    public  LeetCode1621() {

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

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode tn;

    public LeetCode1621(TreeNode root) {
        tn = root;
        tn.val = 0;
        recoverTree(tn.left, 1);
        recoverTree(tn.right, 2);
    }

    public boolean find(int target) {
        return find(tn, target);
    }

    void recoverTree(TreeNode root, int x) {
        if (root == null) return;
        root.val = x;
        recoverTree(root.left, 2*x + 1);
        recoverTree(root.right, 2*x + 2);
    }

    public boolean find(TreeNode root, int target) {

        if (root == null) return false;
        if (root.val == target) return true;
        if (root.val > target) return find(root.left, target);
        else return find(root.right, target);
    }

/**
 Your FindElements object will be instantiated and called as such:
 FindElements obj = new FindElements(root);
 boolean param_1 = obj.find(target);
 */
}
