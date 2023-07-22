package com.leetcode75;

public class LC2095 {

    /**
     * Definition for singly-linked list.
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

    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        System.out.println();
        tmp = head;
        ListNode tmp2 = head;
        for (int i = 0; i <= count / 2; i++) {
            if (i == count / 2) {
                tmp2 = tmp2.next;
                ListNode hd = tmp2;
                hd = null;
            }
            tmp2 = tmp2.next;

        }
        return head;
    }
}
