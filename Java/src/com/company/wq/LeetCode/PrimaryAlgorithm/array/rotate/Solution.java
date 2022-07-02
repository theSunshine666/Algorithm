package com.company.wq.LeetCode.PrimaryAlgorithm.array.rotate;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int matrix1[][] = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        int matrix2[][] = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        new Solution().rotate2(matrix1);
        for (int i = 0; i < matrix1.length; i ++){
            System.out.println(Arrays.toString(matrix1[i]));
        }
    }

    //借用临时矩阵
    public void rotate(int[][] matrix) {
        int[][] temp;
        int len = matrix.length;
        temp = new int[len][len];
        for (int i = len - 1,k = 0; i >= 0; i--,k++){
            for (int j = 0; j < len; j++){
                temp[j][k] = matrix[i][j];
            }
        }
        for (int i = 0; i < len; i ++){
            for (int j = 0; j < len; j ++){
                matrix[i][j] = temp[i][j];
            }
        }
    }

    //直接旋转
    public void rotate2(int[][] matrix){
        int tem;
        int len = matrix.length;
        for (int i = 0; i < len / 2 + 1; i++){
            for (int j = 0; j < len / 2 + 1;j++){
                tem = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
            }
        }
    }
}
