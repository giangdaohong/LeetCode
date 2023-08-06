package com.leetcode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC2352 {

    public static void main(String[] args) {
        String a = "adb";
        a.indexOf("a");
    }
    public int equalPairs(int[][] grid) {
        int rs = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int[] col = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                col[i] = grid[i][j];
            }
            for (int k = 0; k < grid.length; k++) {
                if (Arrays.equals(col, grid[k])) {
                    rs++;
                }
            }
        }
        return rs;
    }

    public int equalPairs2(int[][] grid) {
        int rs = 0;
        // rotate matrix form row x col => col x row :D
        int[][] auxiliary = new int[grid.length][grid[0].length];

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                auxiliary[j][i] = grid[i][j];
                //System.out.print(auxiliary[j][i] + " ");
            }
            //System.out.println();
        }
        System.out.println(Arrays.deepToString(auxiliary));

        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                if (Arrays.equals(grid[i], auxiliary[j])) {
                    rs++;
                }
            }
        }
        return rs;
    }

    class TrieNode {
        int count;
        Map<Integer, TrieNode> children;

        public TrieNode() {
            this.count = 0;
            this.children = new HashMap<>();
        }
    }

    class Trie {
        TrieNode trie;

        public Trie() {
            this.trie = new TrieNode();
        }

        public void insert(int[] array) {
            TrieNode myTrie = this.trie;
            for (int a : array) {
                if (!myTrie.children.containsKey(a)) {
                    myTrie.children.put(a, new TrieNode());
                }
                myTrie = myTrie.children.get(a);
            }
            myTrie.count += 1;
        }

        public int search(int[] array) {
            TrieNode myTrie = this.trie;
            for (int a : array) {
                if (myTrie.children.containsKey(a)) {
                    myTrie = myTrie.children.get(a);
                } else {
                    return 0;
                }
            }
            return myTrie.count;
        }
    }

    class Solution {
        public int equalPairs(int[][] grid) {
            Trie myTrie = new Trie();
            int count = 0, n = grid.length;

            for (int[] row : grid) {
                myTrie.insert(row);
            }

            for (int c = 0; c < n; ++c) {
                int[] colArray = new int[n];
                for (int r = 0; r < n; ++r) {
                    colArray[r] = grid[r][c];
                }
                count += myTrie.search(colArray);
            }

            return count;
        }
    }
}
