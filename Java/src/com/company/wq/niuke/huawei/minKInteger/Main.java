package com.company.wq.niuke.huawei.minKInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
            new Main().findKMinInteger(k,arr,n);
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        scanner.close();
    }

    //选择排序
    public void findKMinInteger(int k,int[] arr,int length){
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
