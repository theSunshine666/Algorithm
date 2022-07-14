package com.company.wq.classicalAlgorithm.dynamicProgramming.backPack01;

/**
 * 0-1背包：
 * 描述：
 * 有m件物品，物品有它的价值v和重量w，现有一个背包，能够承受装入物品的最大重量为V（或者背包容量为V），
 * 求装入该背包的物品的最大价值为多少？
 * 解法：动态规划
 */
public class Backpack01 {
    public static void main(String[] args) {
        int[][] goods = { {6,3},{10,1},{5,2},{10,4} };
        int capacity = 6;
        System.out.println(Backpack01.maxValue(goods,capacity));
    }

    /**
     *
     * @param goods  二维数组，第一列表示物品的价值，第二列表示物品的重量
     * @param capacity  背包能承受的最大重量（或者叫背包的容量）
     * @return
     */
    public static int maxValue(int[][] goods,int capacity){
        int goodsLen = goods.length;
        int[] v = new int[goodsLen+1];
        int[] w = new int[goodsLen+1];
        int[][] pd = new int[goodsLen+1][capacity+1];
        //先初始化,v代表物品的价值，w代表物品的重量
        for (int i = 1; i < goodsLen+1; i++) {
            v[i] = goods[i-1][0];
            w[i] = goods[i-1][1];
        }
        //填充表，i代表物品，j代表背包容量
        for (int i = 1; i < goodsLen + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                // 如果当前物品的重量 < 背包的容量（即背包能装下该物品）
                // pd[i][j]取该物品不装背包和装入背包的最大值
                if (w[i] <= j){
                    pd[i][j] = Math.max(pd[i-1][j],pd[i-1][j-w[i]]+v[i]);
                }else {
                    pd[i][j] = pd[i-1][j];
                }
            }
        }
        return pd[goodsLen][capacity];
    }
}
