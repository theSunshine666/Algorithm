package com.company.wq.classicalAlgorithm.dynamicProgramming.sellStocksBestTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null){
            String[] priceStr = str.split(",");
            int n = priceStr.length;
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(priceStr[i]);
            }
//            System.out.println(Arrays.toString(prices));
            System.out.println(maxProfit(prices));

        }
        br.close();
    }

    public static int maxProfit(int[] prices){
        int n = prices.length;
        if (n <= 1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int curr = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1];
            curr = dp[i];
            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j]){
                    dp[i] = Math.max(curr,prices[i]-prices[j]);
                    curr = dp[i];
                }
            }
        }
        return dp[n-1];
    }
}
