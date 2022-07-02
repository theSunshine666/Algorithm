package com.company.wq.niuke.huawei.sortIntegerArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int flag = scanner.nextInt();
            Main main = new Main();
            if (flag == 0){
//                Arrays.sort(arr);
                main.acSort(arr,0,n-1);
            }
            if (flag == 1){
                main.deSort(arr,0,n-1);
            }
            main.print(arr,n);
        }

        scanner.close();
    }


    //快速排序
    public void deSort(int[] arr,int low,int high){
        if (low > high){
            return;
        }
        int pivot = arr[high];
        int left = low;
        int right = high;
        while (left != right){
            while (left < right && arr[left] >= pivot){
                left++;
            }
            while (left < right && arr[right] <= pivot){
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] =temp;
        }
        arr[high] = arr[left];
        arr[left] = pivot;
        deSort(arr,low,left-1);
        deSort(arr,right+1,high);
    }

    public void acSort(int[] arr,int low,int high){
        if (low > high){
            return;
        }
        int pivot = arr[low];
        int left = low;
        int right = high;
        while (left != right){
            while (left < right && arr[right] >= pivot){
                right--;
            }
            while (left < right && arr[left] <= pivot){
                left++;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] =temp;
        }
        arr[low] = arr[left];
        arr[left] = pivot;
        acSort(arr,low,left-1);
        acSort(arr,right+1,high);
    }

    public void print(int[] arr,int len){
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
