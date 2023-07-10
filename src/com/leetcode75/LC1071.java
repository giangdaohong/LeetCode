package com.leetcode75;

public class LC1071 {

	public static void main(String[] args) {
		System.out.println(new LC1071().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
				"TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
	}

	public String gcdOfStrings(String str1, String str2) {

		String tem = str1;

		if (str1.length() > str2.length()) {
			str1 = str2;
			str2 = tem;
		}

		int len1 = str1.length();
		int len2 = str2.length();

		int len = Math.min(len1, len2);

		int i = 1;
		for (int seq = len; seq >= 1; seq = len / i) { // 6, 8

			if (len1 % seq != 0 || len2 % seq != 0) {
				i++;
				continue;
			}
			if (str1.charAt(0) != str2.charAt(0)) { // AB vs AC
				break;
			}

			int idx = 0;
			String div = str1.substring(0, seq);

			while (idx < len) {
				if (str1.substring(idx, idx + seq).equals(str2.substring(idx, idx + seq))
						&& str1.substring(idx, idx + seq).equals(div)) {

				} else {
					break;
				}
				idx += seq;
			}

			if (idx >= len) {

				while (idx + seq <= len2 && div.equals(str2.substring(idx, idx + seq))) {
					idx += seq;
				}

				if (idx >= str2.length()) {
					return div;
				}
			}

			i++;

		}
		return "";
	}

}
