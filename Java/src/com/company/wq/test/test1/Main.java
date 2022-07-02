package com.company.wq.test.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        while (in.hasNextInt()){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
        }
        int result = main.matrixMax(n,matrix);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        in.close();
    }
    public int matrixMax(int n,int[][] matrix){
        int result = 0;
        return result;
    }
}
