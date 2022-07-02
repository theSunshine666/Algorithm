package com.company.wq.niuke.huawei.stringDelimited;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            //解法一：将字符串补充至8的整数倍，再截取
            int len = string.length();
            int zeroNum = 8 - (len % 8);
            if (zeroNum != 8) {
                for (int i = 0; i < zeroNum; i++) {
                    string += "0";
                }
            }
            int newLen = string.length();
            for (int i = 0; i < newLen / 8; i++) {
                System.out.println(string.substring(0, 8));
                string = string.substring(8);
            }
            //解法二：
            String string2 = scanner.nextLine();
            while (string2.length() > 8) {
                System.out.println(string2.substring(0, 8));
                string2 = string2.substring(8);
            }
            string2 += "00000000";
            System.out.println(string2.substring(0, 8));

        }
        scanner.close();
    }
}
