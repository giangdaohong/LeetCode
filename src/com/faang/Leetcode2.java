package com.faang;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 2.Add Two Numbers
 */

public class Leetcode2 {

    public static void main(String[] args) {
        ListNode rs = new Leetcode2().new ListNode(2);
        rs.next = new Leetcode2().new ListNode(4);
        rs.next.next = new Leetcode2().new ListNode(3);


        ListNode l2 = new Leetcode2().new ListNode(5);
        l2.next = new Leetcode2().new ListNode(6);
        l2.next.next = new Leetcode2().new ListNode(4);

        new Leetcode2().addTwoNumbers(rs, l2);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre_remain = 0;
        ListNode result = new ListNode(0);
        ListNode currentCursor = result;
        while (l1 != null || l2 != null) {
            int sum = 0;
            int cur = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + pre_remain;
                if (sum == 10) {
                    cur = 0;
                    pre_remain = 1;
                } else if (sum > 10) {
                    pre_remain = 1;
                    cur = sum - 10;
                } else {
                    cur = sum;
                }

                currentCursor.next = new ListNode(cur);
                currentCursor = currentCursor.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                sum = l2.val + pre_remain;
                if (sum == 10) {
                    cur = 0;
                    pre_remain = 1;
                } else if (sum > 10) {
                    pre_remain = 1;
                    cur = sum - 10;
                } else {
                    cur = sum;
                }
                currentCursor.next = new ListNode(cur);
                currentCursor = currentCursor.next;
                l2 = l2.next;
            } else {
                sum = l1.val + pre_remain;
                if (sum == 10) {
                    cur = 0;
                    pre_remain = 1;
                } else if (sum > 10) {
                    pre_remain = 1;
                    cur = sum - 10;
                } else {
                    cur = sum;
                }
                currentCursor.next = new ListNode(cur);
                currentCursor = currentCursor.next;
                l1 = l1.next;
            }
        }
        return result.next;
    }


    /**
     * Definition for singly-
     * linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
