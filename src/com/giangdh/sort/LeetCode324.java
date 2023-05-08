package com.giangdh.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode324 {

	public static void main(String[] args) {
		int[] nums = { 5, 6, 7, 8, 9 };
		List<Integer> preProduct = new ArrayList<>();
		
		// k = 5
		
		//	 pivot = 2 < k
		
		//   6, 5, 7, 9, 8 
		
		//   left = 3  6, 5, 7, 9, 8 
		
		//	 6, 5, 7, 8, 9 

	}

	// 1, 1, 1, 4, 5, 6
	public void wiggleSort(int[] nums) {
		int[] arr = nums.clone();
		Arrays.sort(arr);
		int n = nums.length;
		int i = (n - 1) / 2, j = n - 1;
		for (int x = 0; x < n; ++x) {
			if (x % 2 == 0) {
				nums[x] = arr[i--];
			} else {
				nums[x] = arr[j--];
			}
		}
		System.out.println("Hello world");
	}

	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
		return Arrays.copyOfRange(points, 0, K);
	}

	public int[][] kClosest_2(int[][] points, int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
		for (int[] p : points) {
			pq.offer(p);
			if (pq.size() > K) {
				pq.poll();
			}
		}
		int[][] res = new int[K][2];
		while (K > 0) {
			res[--K] = pq.poll();
		}
		return res;
	}

	public int[][] kClosest_3(int[][] points, int k) {
		int left = 0;
		int right = points.length - 1;
		int pivotIndex = points.length;
		while (pivotIndex != k) {
			pivotIndex = partition(points, left, right);
			// now binary search to find specific value K
			if (pivotIndex < k) {
				/// if cur pivot is too low move forward it
				left = pivotIndex;
			} else {
				/// if cur pivot is too high move down it
				right = pivotIndex - 1;
			}
		}
		return Arrays.copyOf(points, k);
	}

	public int partition(int[][] points, int left, int right) {
		int[] pivot = points[left + (right - left) / 2];
		int pivotDistance = distance(pivot);
		while (left <= right) {
			while (distance(points[left]) < pivotDistance) {
				left += 1;
			}
			while (distance(points[right]) > pivotDistance) {
				right -= 1;
			}
			if (left <= right) {
				swap(points, left, right);
				left += 1;
				right -= 1;
			}
		}
		return left;
	}

	public void swap(int[][] arr, int left, int right) {
		int[] temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}

}
