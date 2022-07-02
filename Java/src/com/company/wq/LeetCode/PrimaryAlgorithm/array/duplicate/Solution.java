package com.company.wq.LeetCode.PrimaryAlgorithm.array.duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
//        System.out.println(new Solution().containsDuplicate(nums));
//        System.out.println(new Solution().containsDuplicate(nums2));
        System.out.println(new Solution().containsDuplicate3(nums3));
    }

    //简单粗暴方法
    //两层循环，逐个对比是否有相同的
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length-1;i++){
            for(int j = i+1;j < nums.length;j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //先排序后比较
    public boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    //Set集合解法
    public boolean containsDuplicate3(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            //因为集合set中不能有重复的元素，如果有重复的元素添加，就会添加失败
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate4(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //如果有重复的，set中会覆盖，导致size减小，
        //如果没有重复的，set的大小等于nums的长度
        return set.size() != nums.length;
    }
}
