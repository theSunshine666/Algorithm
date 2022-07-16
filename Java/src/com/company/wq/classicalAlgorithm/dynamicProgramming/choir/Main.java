package com.company.wq.classicalAlgorithm.dynamicProgramming.choir;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null){
            //接收输入的字符串，将其转换为int型
            int n = Integer.parseInt(str);
            String input = br.readLine();
            int[] height = new int[n];
            String[] h = input.split(" ");
            for (int i = 0; i < h.length; i++) {
                height[i] = Integer.parseInt(h[i]);
            }
            System.out.println(choir(height,n));
        }
    }

    public static int choir(int[] nums,int n){
        if (n <= 1){
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        //定义动态规划数组，表示第n位同学为最高点时左边的最长递增序列长度和右边的最长递减序列长度之和，
        // 也就是满足合唱队要求的最长队列长度
        int[] dp = new int[n];
        //计算left
        for (int i = 0; i < n; i++) {
            left[i] = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    left[i] = Math.max(left[i],left[j]+1);
                }
            }
        }
        //计算right
        for (int i = n-1; i >= 0; i--) {
            right[n-1] = 0;
            for (int j = n-1; j > i; j--) {
                if (nums[i] > nums[j]){
                    right[i] = Math.max(right[i],right[j]+1);
                }
            }
        }
        //计算dp
        for (int i = 0; i < n; i++) {
            dp[i] = left[i] + right[i] + 1;
        }
        //寻找dp中的最大值
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max){
                max = dp[i];
            }
        }

        return nums.length - max;
    }
}

/**
 124
 16 103 132 23 211 75 155 82 32 48 79 183 13 91 51 172 109 102 189 121 12 120 116 133 79 120 116 208 47 110 65 187 69 143 140 173 203 35 184 49 245 50 179 63 204 34 218 11 205 100 90 19 145 203 203 215 72 108 58 198 95 116 125 235 156 133 220 236 125 29 235 170 130 165 155 54 127 128 204 62 59 226 233 245 46 3 14 108 37 94 52 97 159 190 143 67 24 204 39 222 245 233 11 80 166 39 224 12 38 13 85 21 47 25 180 219 140 201 11 42 110 209 77 136
 */