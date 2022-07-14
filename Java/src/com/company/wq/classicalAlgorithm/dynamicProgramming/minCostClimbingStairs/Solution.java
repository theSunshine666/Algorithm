package com.company.wq.classicalAlgorithm.dynamicProgramming.minCostClimbingStairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null){
            //输入的数字用,隔开，方便读取
            String[] nums = str.split(",");
            //将字符串转为整数
            int[] values = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                values[i] = Integer.parseInt(nums[i]);
            }
            System.out.println(minCostClimbingStairs(values));
        }
        br.close();
    }

    public static int minCostClimbingStairs (int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        if (cost.length >= 2) {
            dp[1] = 0;
            for (int i = 2; i <= cost.length; i++) {
//                dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
                if (dp[i-1]+cost[i-1] > dp[i-2]+cost[i-2]){
                    dp[i] = dp[i-2]+cost[i-2];
                }else {
                    dp[i] = dp[i-1]+cost[i-1];
                }
            }
        }
        return dp[cost.length];
    }
}
