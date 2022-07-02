package com.company.wq.niuke.huawei.firstUniqChar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            int len = s.length();
            int visit[] = new int[26];
            char[] ch = s.toCharArray();
            for (int i = 0; i < len; i++) {
                visit[ch[i]-'a']++;
            }
            for (int i = 0; i < len; i++) {
                if (visit[ch[i]-'a'] == 1){
                    System.out.println(ch[i]);
                    return;
                }
            }
            System.out.println(-1);
        }
//        char result = new Main().firstUniqChar(s);
//        System.out.println(result);
        scanner.close();
    }

    //两次遍历
//    public char firstUniqChar(String s) {
//        int len = s.length();
//        int visit[] = new int[26];
//        char[] ch = s.toCharArray();
//
//        for (int i = 0; i < len; i++) {
//            visit[ch[i]-'a']++;
//        }
//        for (int i = 0; i < len; i++) {
//            if (visit[ch[i]-'a'] == 1){
//                return ch[i];
//            }
//        }
//        return -1;
//    }

    //使用Java API
    public int firstUniqChar2(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
