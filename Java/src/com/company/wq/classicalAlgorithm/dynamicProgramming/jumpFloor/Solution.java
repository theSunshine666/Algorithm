package com.company.wq.classicalAlgorithm.dynamicProgramming.jumpFloor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(jumpFloor2(Integer.parseInt(str)));
        }
        br.close();
    }

    /**
     * 解法一：递归
     * 运行时间：174ms 占用内存：9824KB
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 解法二：动态规划
     * 运行时间：19ms 占用内存：9684KB
     * 定义dp[i]的含义为跳到第i阶台阶有dp[i]中跳法，要跳到第i阶，有两种方法可以跳到，第一种是从第i-1阶跳上来
     * 第二种是从第i-2阶跳上来，因为一次最多只能跳两阶，因此
     * 当i>2时，dp[i]=dp[i-1]+dp[i-2];i<2时，dp[1]=1;dp[2]=2;
     * @param target
     * @return
     */
    public static int jumpFloor2(int target) {
        int[] dp = new int[target];
        dp[0] = 1;
        if (target >= 2) {
            dp[1] = 2;
            for (int i = 2; i < target; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[target-1];
    }
}
