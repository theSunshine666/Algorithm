package com.company.wq.classicalAlgorithm.greedy.sellStockBestTime;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 买卖股票的最好时机（二）：
 * 跟一的区别是：
 * 一从头到尾只能买一次卖一次，而二能够买卖多次，但再次买之前必须把手里的股票卖出
 */
public class sellStocksBestTime {
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
            System.out.println(maxProfit2(prices));
        }
        br.close();
    }

    /**
     * 解法一：贪心算法：
     * 运行时间：243ms 占用内存：23988KB
     * 只要遇到上涨就卖出然后再买进，下降不管
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        if (prices.length <= 1){
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i] - prices[i-1];
            if (curr > 0){
                res += curr;
            }
        }
        return res;
    }

    /**
     * 解法二：动态规划算法：
     * 运行时间：241ms 占用内存：23188KB
     * 与一不同的是一中必须与当天卖出的最大值进行比较，而二中可以多次买卖，只要当天价格高于前一天
     * 就将前一天的最大利润再加上当天卖出的利润
     * dp[i] = Math.max(dp[i-1],dp[i-1]+prices[i]-prices[i-1]);
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices){
        int n = prices.length;
        if (n <= 1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1];
            if (prices[i] > prices[i-1]){
                dp[i] = Math.max(dp[i-1],dp[i-1]+prices[i]-prices[i-1]);
            }
        }
        return dp[n-1];
    }
}
