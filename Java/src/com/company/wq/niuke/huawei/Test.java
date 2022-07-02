package com.company.wq.niuke.huawei;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long num = scanner.nextLong();
            Test test = new Test();
            test.primeFactor(num);
//            boolean result = test.isPrime(num);
//            System.out.println(result);
        }
    }

    public void primeFactor(long num){
        for (int i = 2; i <= num; i++) {
            while (num % i == 0){
                System.out.print(i + " ");
                num /= i;
            }
        }

    }

    public boolean isPrime(int num){
        if (num == 0 || num == 1){
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
