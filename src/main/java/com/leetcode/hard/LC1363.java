package com.leetcode.hard;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC1363 {
    public static void main(String[] args) {
        int [] digits = new int[] {8,1,9};
        System.out.println(new LC1363().singlenumsber(digits));
    }
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        
        int sum = Arrays.stream(digits).sum();
        int i = 0;
        for (; i < digits.length; i++) {
            if(sum % 3 == 0) {
                break;
            }
            sum -= digits[i];
        }
        StringBuilder rs = new StringBuilder();
        for (int j = digits.length - 1; j >= i; j--) {
            rs.append(digits[j]);
        }
        return rs.toString();
    }

    public int singlenumsber(int[] nums) {
        Arrays.sort(nums);
       // if(nums[0] != nums[1]) return nums[0];
        for(int i = 1; i < nums.length -1; i ++) {
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
