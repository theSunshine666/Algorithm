package com.company.wq.LeetCode.PrimaryAlgorithm.array.PlusOne;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = {9,9,9};
        System.out.println(Arrays.toString(solution.plusOne(result)));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--){
            if (digits[i] != 9){
                digits[i] ++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] tem = new int[len+1];
        tem[0] = 1;
        return tem;
    }
}
