package com.company.wq.classicalAlgorithm.dynamicProgramming.sellStocksBestTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 买卖股票的最佳时间（一）
 * 从头到尾只能买一次卖一次
 */
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
            System.out.println(maxProfit(prices));

        }
        br.close();
    }

    /**
     * 解法一：动态规划算法：
     * 运行时间：16ms 占用内存：9900KB
     * 两层遍历：dp[i] = Math.max(curr,prices[i]-prices[j]);
     * @param prices
     * @return
     */
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

    /**
     * 解法二：贪心算法：
     * 运行时间：21ms 占用内存：9760KB
     * 一遍遍历，贪心算法认为这组数组中总有一个最小价格，只要遇到一个比它价格高的且比当前最优解
     * （当前最大利润）更大的就卖掉，遇到比最小价格还小的就更新最小价格
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > res){
                res = prices[i] - minPrice;
            }
        }
        return res;
    }
}
