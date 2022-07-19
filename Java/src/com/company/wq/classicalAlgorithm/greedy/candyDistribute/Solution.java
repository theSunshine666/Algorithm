package com.company.wq.classicalAlgorithm.greedy.candyDistribute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null){
            String[] numsStr = str.split(",");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            int result = candy(nums);
            System.out.println(result);
        }
        br.close();
    }

    public static int candy(int[] arr){
        int n = arr.length;
        //定义count数组用来记录每个孩子分得的糖果数量
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }
        //从左往右遍历，右边的比左边的大，就更新右边的为左边的+1
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]){
                count[i] = count[i-1] + 1;
            }
        }
        //从右往左遍历，左边的比右边的大，且左边的糖果数量比右边的少或者相等，则更新左边的为右边的+1
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[i+1] && count[i] <= count[i+1]){
                count[i] = count[i+1]+1;
            }
        }
        //将所有糖果数加起来就是最后的结果
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += count[i];
        }
        return result;
    }
}
