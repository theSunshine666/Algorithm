package com.company.wq.niuke.huawei.qualifiedPassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = reader.readLine()) != null && !input.equals("")) {
            char[] chars = input.toCharArray();
            int count = 0;
            int a = 0, b = 0, d = 0, e = 0;
            boolean flag = true;
            if (input.length() > 8) {
                for (char c : chars) {
                    if (c >= '0' && c <= '9') {
                        a = 1;
                    } else if (c >= 'a' && c <= 'z') {
                        b = 1;
                    } else if (c >= 'A' && c <= 'Z') {
                        d = 1;
                    } else if (c == ' ' || c == '\n') {
                        flag = false;
                        break;
                    } else {
                        e = 1;
                    }
                }
            }

//            System.out.println("a="+a+",b="+b+",d="+d+",e="+e);
            if (flag) {
                if (a + b + e + d >= 3) {
                    if (ifRepeatStr(input)) {
                        //存在重复子串
                        System.out.println("OK");
                    } else {
                        //不存在重复子串
                        System.out.println("NG");
                    }
                } else {
                    //满足条件小于3
                    System.out.println("NG");
                }
            } else {
                //有空格或换行
                System.out.println("NG");
            }
        }
    }

    public static boolean ifRepeatStr(String s) {
        for (int i = 3; i < s.length(); i++) {
            if (s.substring(i).contains(s.substring(i - 3, i))) {
                return false;
            }
        }
        return true;
    }
}
