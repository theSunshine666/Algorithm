package com.company.wq.LeetCode.PrimaryAlgorithm.array.rotateArray;

import java.util.Arrays;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RotateArray {

    public static void main(String[] args) {
        int nums1[] = {1,2,3,4,5,6,7};
        int nums2[] = {1,2};
        int nums3[] = {-1,-100,3,99};
        int k = 2;
//        int k = 3;
//        new RotateArray().rotate(nums2,k);
//        new RotateArray().rotate2(nums2,k);
//        new RotateArray().rotate3(nums2,k);
        new RotateArray().rotate4(nums3,k);
        System.out.println(Arrays.toString(nums3));
    }

    //  第一种解法，使用临时数组
    public void rotate(int[] nums, int k) {
        if (k % nums.length == 0){
            return;
        }
        if (k < nums.length){
            rotateAct(nums,k);
        }
        if(k > nums.length){
            rotateAct(nums,k%nums.length);
        }
    }
    private void rotateAct(int[] nums,int k){
        int tem[] = new int[nums.length];
        System.arraycopy(nums,nums.length-k,tem,0,k);
        System.arraycopy(nums,0,nums,k,nums.length-k);
        System.arraycopy(tem,0,nums,0,k);
    }

    //循环k次
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        for (int i=0;i<k%len;i++){
            rotateOnce(nums);
        }
    }
    private void rotateOnce(int[] nums){
        int i,len = nums.length - 1;
        int temp = nums[len];
        System.out.println(nums[len]);
        for (i = len;i > 0;i--){
            nums[i] = nums[i-1];
        }
        nums[i] = temp;
    }

    //反转
    public void rotate3(int[] nums, int k) {
        int len = nums.length - 1;
        int tem = k % nums.length;
        reverse(nums,0,len);
        reverse(nums,0,tem-1);
        reverse(nums,tem,len);
    }
    private void reverse(int[] nums,int start,int end){
        int temp;
        for (int i = start;i < end; i++){
            temp = nums[i];
            nums[i] = nums[end];
            nums[end] = temp;
            end--;
        }
    }

    //环形旋转
    public void rotate4(int[] nums, int k) {
        int temp = nums[0];
        int index = 0;
        int len = nums.length;
        boolean visited[] = new boolean[len];

        for (int i = 0; i < len;i++){
            index = (index + k) % len;
            if (visited[index]){
                index = (index + 1) % len;
                temp = nums[index];
                i--;
            }else {
                visited[index] = true;
                int temp2 = nums[index];
                nums[index] = temp;
                temp = temp2;
            }
        }
    }


}
