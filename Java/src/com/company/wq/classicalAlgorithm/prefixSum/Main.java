package com.company.wq.classicalAlgorithm.prefixSum;

import java.util.Arrays;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,3,7,5,2};
        int m = 3;
        int[][] lr = new int[m][2];
        lr = new int[][]{{0, 2}, {0, 4},{2,4}};

        int[] result = new Main().prefixSum(n,arr,m,lr);
        System.out.println(Arrays.toString(result));
    }


    public int[] prefixSum(int n,int[] arr,int m,int[][] lr){
        int[] result = new int[m];
        int[] sum = new int[n];
        //计算sum[0,R]
        sum[0] = arr[0];
        for (int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 0; i < m; i++) {
            if (lr[i][0] != 0){
                result[i] = sum[lr[i][1]] - sum[lr[i][0] - 1];
            }else {
                result[i] = sum[lr[i][1]];
            }

        }
        return result;
    }

}
