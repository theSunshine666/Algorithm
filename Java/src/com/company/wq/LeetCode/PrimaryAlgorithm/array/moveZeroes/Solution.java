package com.company.wq.LeetCode.PrimaryAlgorithm.array.moveZeroes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] nums1 = {1,0,1};
        int[] nums2 = {4,2,4,0,0,3,0,5,1,0};
        new Solution().moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }


    //双指针解法
    public void moveZeroes(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }
        int left=0,temp;
        for (int right = 0; right < nums.length;right++){
            if (nums[right] != 0){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    //把非0的数往前移动
    public void moveZeroes2(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }
        int index = 0, len = nums.length,temp;
        for (int i = 0; i < len; i++){
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for (;index< nums.length;index++){
            nums[index] = 0;
        }
    }
}