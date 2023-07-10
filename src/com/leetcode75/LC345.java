package com.leetcode75;

public class LC345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseVowels(String s) {

		char[] charIput = s.toCharArray();

		int i = 0;
		int j = s.length() - 1;
		String st = new String("aeiouAEIOU");

		while (i <= j && i < s.length() - 1 && j >= 0) {
			if (st.indexOf(charIput[i]) >= 0 && st.indexOf(charIput[j]) >= 0) {
				char tmp = charIput[i];
				charIput[i] = charIput[j];
				charIput[j] = tmp;
				i++;
				j--;
			} else if (st.indexOf(charIput[i]) >= 0) {
				j--;
			} else if (st.indexOf(charIput[j]) >= 0) {
				i++;
			} else {
				i++;
				j--;
			}

		}
		return new String(charIput);
	}

}
