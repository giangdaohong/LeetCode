package com.giangdh.trie;

public class LeetCode14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1) {
			return strs[0];
		}
		int maxLeng = strs[0].length();

		if (maxLeng == 0) {
			return "";
		}

		int max = 0;

		for (int i = 1; i <= maxLeng; i++) {
			String cur = strs[0].substring(0, i);
			boolean isExist = true;
			for (String st : strs) {
				if (i > st.length() || !cur.equals(st.substring(0, i))) {
					isExist = false;
					break;
				}
			}
			if (isExist) {
				max++;
			} else {
				break;
			}

		}
		return strs[0].substring(0, max);
	}

}
