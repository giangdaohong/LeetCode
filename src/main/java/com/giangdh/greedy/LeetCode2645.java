package com.giangdh.greedy;

public class LeetCode2645 {
    public static void main(String[] args) {
        LeetCode2645 ins = new LeetCode2645();
        System.out.println(ins.addMinimum("aabbca"));
    }

    public int addMinimum(String word) {
        int i = 0;
        int cnt = 0;
        int len = word.length();
        while (i < len) {
            if (word.charAt(i) == 'a') {
                // 'a' in the end
                if (i + 1 >= len) {
                    cnt += 2;
                    break;
                } else if (word.charAt(i + 1) == 'b' && i + 2 >= len) {
                    // 'i + 1' in the end
                    cnt++;
                    break;
                } else if (i + 2 < len && word.charAt(i + 1) == 'b' && word.charAt(i + 2) == 'c') {
                    i += 3;
                } else if (i + 2 < len && word.charAt(i + 1) == 'b' && word.charAt(i + 2) != 'c') {
                    cnt += 1;
                    i += 2;
                } else if (i + 1 < len && word.charAt(i + 1) == 'c') {
                    cnt += 1;
                    i += 2;
                } else if (i + 1 < len && word.charAt(i + 1) == 'a') {
                    cnt += 2;
                    i++;
                }
            } else if (word.charAt(i) == 'b') {
                if (i + 1 >= len) {
                    cnt += 2;
                    break;
                } else if (i + 1 <= len && word.charAt(i + 1) == 'c') {
                    cnt++;
                    i += 2;
                } else if (i + 1 <= len && word.charAt(i + 1) != 'c') {
                    cnt += 2;
                    i++;
                }
            } else {
                cnt += 2;
                i++;
            }
        }
        return cnt;
    }
}
