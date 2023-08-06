package com.topInterview150;

public class LeetCode80 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        new LeetCode80().removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i++];
            } else {
                nums[k++] = nums[i++];
                if (i < nums.length) {
                    int j = i + 1;
                    while (j < nums.length - 1 && nums[j] == nums[j - 1]) {
                        j++;
                        i++;
                    }
                }
            }
        }
        return k;
    }
}
