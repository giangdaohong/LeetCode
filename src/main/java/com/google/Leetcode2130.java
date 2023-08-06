package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 2130. Maximum Twin Sum of a Linked List
 */
public class Leetcode2130 {
    public static void main(String[] args) {
        // 5,4,2,1
        ListNode head = new Leetcode2130().new ListNode(5);
        head.next = new Leetcode2130().new ListNode(4);
        head.next.next = new Leetcode2130().new ListNode(2);
        head.next.next.next = new Leetcode2130().new ListNode(1);
        System.out.println(new Leetcode2130().pairSum(head));
    }

    public int pairSum(ListNode head) {
        List<ListNode> lst = new ArrayList<>();
        ListNode tmp = head;
        int cnt = 0;
        while (tmp != null) {
            lst.add(tmp);
            tmp = tmp.next;
            cnt++;
        }
        int max = 0;
        for (int i = 0; i < cnt / 2; i++) {
            max = Math.max(max, lst.get(i).val + lst.get(cnt - 1 - i).val);
        }
        return max;
    }

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
}
