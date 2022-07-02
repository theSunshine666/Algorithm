package com.company.wq.LeetCode.PrimaryAlgorithm.array.removeDupInSortedArray;

public class RemoveDupInSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDupInSortedArray().removeDuplicates(nums));
    }

    /**
     * 时间复杂度O(n),空间复杂度O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int j = 0;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return ++j;
    }
}
