package com.company.wq.niuke.huawei.primeFactor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long num = scanner.nextLong();
            Main main = new Main();
            main.primeFactor2(num);
        }
        scanner.close();
    }

    /**
     * 时间复杂度太大，不将循环减半的话会超时
     * @param num
     */
//    public void primeFactor(long num){
//        long k = (long) Math.sqrt(num);
//        for (long i = 2; i <= k; ++i) {
//            while (num % i == 0){
//                System.out.print(i + " ");
//                num /= i;
//            }
//        }
//        System.out.println(num == 1 ? "" : num + " ");
//    }

    public void primeFactor2(long num){
        long x = num;
        long y = 2;
        while (x > 1){
            if (x % y == 0){
                x /= y;
                System.out.print(y + " ");
            }else if (y > x / y){
                y = x;
            }else {
                y++;
            }
        }
    }
}
