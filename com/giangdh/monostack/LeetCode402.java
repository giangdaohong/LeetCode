package com.giangdh.monostack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode402 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "112";
		int k = 1;

		System.out.println(removeKdigits(num, k));

	}

	public static String removeKdigits(String num, int k) {

		if ("".equals(num))
			return "0";

		List<Integer> lst = new ArrayList<>();

		for (int cntRmv = 0; cntRmv < k; cntRmv++) {
			int preIdx = 0;
			while (preIdx < num.length()) {
				if (!lst.contains(preIdx)) {
					break;
				}
				preIdx++;
			}
			int pre = Integer.valueOf(num.substring(preIdx, preIdx + 1));
			for (int i = 0; i < num.length() - 1; i++) {

				if (lst.contains(i)) {
					continue;
				}

				int afterIdx = i + 1;
				while (afterIdx < num.length()) {
					if (!lst.contains(afterIdx)) {
						break;
					}
					afterIdx++;
				}

				int after = Integer.valueOf(num.substring(afterIdx, afterIdx + 1));

				int curr = Integer.valueOf(num.substring(i, i + 1));

				if (curr >= after && curr >= pre) {
					lst.add(i);
					break;
				} else {
					pre = curr;
				}
			}

		}

		if (lst.size() == 0)
			return num;
		// Collections.sort(lst);
		StringBuilder sb = new StringBuilder();
		sb.append(num.substring(0, lst.get(0)));
		sb.append(num.substring(lst.get(0) + 1, num.length()));

		StringBuilder res = new StringBuilder();

		for (int i = 1; i < lst.size(); i++) {
			res = new StringBuilder();
			res.append(sb.substring(0, lst.get(i) - 1));
			res.append(sb.substring(lst.get(i), sb.length()));
			sb = new StringBuilder(res.toString());

		}

		String resStr = sb.toString();

		if (resStr.charAt(0) == '0') {
			resStr = resStr.substring(1, resStr.length());
		}

		// 1432219 -> 132219 -> 12219 -> 1219
		return num.length() == 0 ? "0" : resStr;
		// 11111122222222

		// 12345 del = 1 => 1234
	}

}
