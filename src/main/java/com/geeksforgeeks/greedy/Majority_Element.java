package com.geeksforgeeks.greedy;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int majorityElement(int a[], int size)
    {
        // your code here
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < size; i ++) {
			if(map.getOrDefault(a[i], 0) + 1 >= size/2) return a[i];
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		
		return -1;
    }

}
