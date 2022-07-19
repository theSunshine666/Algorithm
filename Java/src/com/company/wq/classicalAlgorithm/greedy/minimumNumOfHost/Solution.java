package com.company.wq.classicalAlgorithm.greedy.minimumNumOfHost;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
////            String temp = scanner.nextLine(); //用来接收回车符
//            int[][] activities = new int[n][2];
//            for (int i = 0; i < n; i++) {
//                activities[i][0] = scanner.nextInt();
//                activities[i][1] = scanner.nextInt();
//            }
//            int result = minmumNumberOfHost(n, activities);
//            System.out.println(result);
//        }
//        scanner.close();

        int n = 2;
        int[][] startEnd = {{1,2},{2,3}};

        int n2 = 3;
        int[][] startEnd2 = {{1,3},{2,4},{2,3}};

        int result = minmumNumberOfHost(n2,startEnd2);
        System.out.println(result);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public static int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here
        int[] start = new int[n];
        int[] end = new int[n];
        //将开始时间和结束时间进行排序
        for (int i = 0; i < n; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }

        Arrays.sort(start,0,start.length);
        Arrays.sort(end,0,end.length);

        int count = 1;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (start[i] >= end[j]) {
                j++;
            } else {
                count++;
            }
        }
        return count;
    }
}
