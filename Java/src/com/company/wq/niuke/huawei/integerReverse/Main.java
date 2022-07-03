package com.company.wq.niuke.huawei.integerReverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            Main main = new Main();
            String result = main.integerReverse2(num);
            System.out.println(result);
        }
        scanner.close();
    }

    public String integerReverse(int num){
        String string = String.valueOf(num);
        String result = "";
        char[] ch = string.toCharArray();
        for (int i = string.length() - 1; i >= 0; i--) {
            result += ch[i];
        }
        return result;
    }

    public String integerReverse2(int num){
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        return stringBuilder.reverse().toString();
    }
}
