package com.company.wq.classicalAlgorithm.dynamicProgramming.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n;
        while ((n = br.readLine()) != null){
            System.out.println(Fibonacci2(Integer.parseInt(n)));
        }
        br.close();
    }

    /**
     * 解法一：递归
     * 运行时间：350ms 占用内存：9828KB
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n == 1 || n == 2){
            return 1;
        }else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

    /**
     * 解法二：动态规划算法
     * 运行时间：22ms 占用内存：9784KB
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n >= 2){
            dp[1] = 1;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n-1];
    }
}
