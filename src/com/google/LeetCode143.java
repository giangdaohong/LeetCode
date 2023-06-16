package com.google;

/**
 * 143. Reorder List
 */
public class LeetCode143 {
    public static void main(String[] args) {
        ListNode ln = new LeetCode143().new ListNode(1);
        ln.next = new LeetCode143().new ListNode(2);
        ln.next.next = new LeetCode143().new ListNode(3);
        ln.next.next.next = new LeetCode143().new ListNode(4);
        ln.next.next.next.next = new LeetCode143().new ListNode(5);

        new LeetCode143().reorderList(ln);

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

    public void reorderList(ListNode head) {
        ListNode tmp = head;
        int i = 1;
        // count size of list node
        while (tmp.next != null) {
            i++;
            tmp = tmp.next;
        }
        if (i == 1) {
            // nothing changed
            return;
        }
        tmp = head;
        ListNode[] arr = new ListNode[i];
        ListNode[] arr2 = new ListNode[i];
        int j = 0;
        int n = i - 1;
        while (tmp.next != null) {
            arr[j++] = tmp;
            arr2[n--] = tmp;
            tmp = tmp.next;
        }
        arr[j] = tmp;
        arr2[n] = tmp;

        tmp = head;
        tmp.next = new ListNode(arr2[0].val);
        tmp = tmp.next;
        for (int k = 1; k < i / 2; k++) {
            tmp.next = new ListNode(arr[k].val);
            tmp.next.next = new ListNode(arr2[k].val);
            tmp = tmp.next.next;
        }
        if (i % 2 == 1) {
            tmp.next = new ListNode(arr[i / 2].val);
        }
    }
}

