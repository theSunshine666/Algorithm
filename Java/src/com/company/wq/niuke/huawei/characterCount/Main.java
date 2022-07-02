package com.company.wq.niuke.huawei.characterCount;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Main main = new Main();
            String string = sc.nextLine();
            int result = main.countCharacter(string);
            System.out.println(result);
        }
        sc.close();
    }

//    public int countCharacter(String string){
//        int[] chars = new int[128];
//        int count = 0;
//        char[] s = string.toCharArray();
//        for (int i = 0; i < string.length(); i++) {
//            chars[s[i] - '0']++;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] != 0){
//                count++;
//            }
//        }
//        return count;
//    }

    public int countCharacter(String string){
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            hashSet.add(string.charAt(i));
        }
        return hashSet.size();
    }
}
