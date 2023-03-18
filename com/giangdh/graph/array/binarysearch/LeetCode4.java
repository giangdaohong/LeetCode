package com.giangdh.graph.array.binarysearch;

public class LeetCode4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] {};
		int[] nums2 = new int[] { 2, 3 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out.println(findMedianSortedArrays2(nums1, nums2));

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 1, 9, 15
		// 4, 5, 18
		int i = 0;
		int j = 0;
		int[] tmp = new int[nums1.length + nums2.length];
		int idx = 0;
		while (i < nums1.length & j < nums2.length) {

			if (nums1[i] < nums2[j]) {
				tmp[idx] = nums1[i];
				i++;
			} else {
				tmp[idx] = nums2[j];
				j++;
			}

			idx++;

		}

		if (i == nums1.length) {
			while (idx < tmp.length && j < nums2.length) {
				tmp[idx] = nums2[j];
				idx++;
				j++;
			}
		} else if (j == nums2.length) {
			while (idx < tmp.length && i < nums1.length) {
				tmp[idx] = nums1[i];
				idx++;
				i++;
			}
		}
//		for (int out : tmp) {
//			System.out.print(out);
//		}
		if (tmp.length % 2 == 1) {
			return tmp[tmp.length / 2];
		}

		return Double.valueOf(tmp[tmp.length / 2] + tmp[tmp.length / 2 - 1]) / 2;

	}

	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int i = 0;
		int j = 0;
		int newLength = (nums1.length + nums2.length) / 2 + 1;
		int[] tmp = new int[newLength];
		int idx = 0;
		while (i < nums1.length & j < nums2.length && idx < newLength) {

			if (nums1[i] < nums2[j]) {
				tmp[idx] = nums1[i];
				i++;
			} else {
				tmp[idx] = nums2[j];
				j++;
			}
			idx++;
		}
		if (idx == 0) {
			if (nums1.length == 0) {
				for (; j < nums2.length; j++)
					tmp[j] = nums2[j];
			} else {
				for (; i < nums1.length; i++)
					tmp[i] = nums1[i];
			}
		}
		if (idx < newLength) {
			if (j < nums2.length) {
				for (; idx < newLength && j < nums2.length; idx++, j++) {
					tmp[idx] = nums2[j];
				}
			} else {
				for (; idx < newLength && i < nums1.length; idx++, i++) {
					tmp[idx] = nums1[i];
				}
			}
		}
		if (idx == newLength) {
			idx--;
		}

		if (tmp.length == 1) {
			return tmp[idx];
		}

		if ((nums1.length + nums2.length) % 2 == 1) {
			return tmp[idx];

		}
		
		return Double.valueOf(tmp[tmp.length - 1] + tmp[tmp.length - 2]) / 2;

	}

}
