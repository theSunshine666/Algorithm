package com.company.wq.niuke.huawei.interceptString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            int k = scanner.nextInt();
            //解法一：使用String的charAt方法，遍历字符串前k个字符
            for (int i = 0; i < k; i++) {
                System.out.print(string.charAt(i));
            }
            System.out.println();
            //解法二：使用String的substring方法，截取从0到k的字符
            System.out.println(string.substring(0,k));
        }
        scanner.close();
    }
}
