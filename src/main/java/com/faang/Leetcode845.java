package com.faang;

import java.util.ArrayList;
import java.util.List;

public class Leetcode845 {

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 2, 3};
        System.out.println(new Leetcode845().longestMountain(arr));
    }

    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;
        List<Integer> store = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i + 1] > arr[i]) {
                    store.add(i);
                }
            } else if (i == arr.length - 1) {
                if (arr[i] < arr[i - 1]) {
                    store.add(i);
                }
            } else if (arr[i] < arr[i - 1] && arr[i + 1] > arr[i]) {
                // bellow
                store.add(i);
            } else if (arr[i] == arr[i - 1] && arr[i + 1] > arr[i]) {
                store.add(Integer.MAX_VALUE);
                store.add(i);
            } else if (arr[i] < arr[i - 1] && arr[i + 1] == arr[i]) {
                store.add(i);
            } else if (arr[i] == arr[i - 1]) {
                store.add(Integer.MAX_VALUE);
                if (arr[i + 1] > arr[i]) {
                    store.add(i + 1);
                }
            }
        }
        int max = 0;
        for (int i = 1; i < store.size(); i++) {
            if (store.get(i) != Integer.MAX_VALUE && store.get(i - 1) != Integer.MAX_VALUE) {
                max = Math.max(max, store.get(i) - store.get(i - 1) + 1);
            }
        }
        return max;
    }
}
