package com.company.wq.LeetCode.PrimaryAlgorithm.array.apearOnceNumber;

import java.util.HashSet;
import java.util.Set;

public class OnlyAppearOnceNumber {
//    复习位运算，相同为1，不同为0
    public static void main(String[] args) {
//        System.out.println(1&2);
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        System.out.println(new OnlyAppearOnceNumber().singleNumber2(nums2));
    }

    //异或运算法
    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length;i++){
            temp ^= nums[i];
        }
        return temp;
    }

    //Set集合法
    public int singleNumber2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i =0;i<nums.length;i++){
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        return (int)set.toArray()[0];
    }
}
