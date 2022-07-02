package com.company.wq.LeetCode.PrimaryAlgorithm.array.twoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] nums1 = {3,2,4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum2(nums1,6)));
    }

    //暴力求解法
    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i] + nums[j] == target){
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    //使用HashMap解决
    public int[] twoSum2(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
