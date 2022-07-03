package com.company.wq.niuke.huawei.stringSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //用n接收一个nextInt后，输入的回车会被nextLine给接收，所以排序后会少最后输入的字符串
        //解决办法是将nextLine()换成next()方法，next()不接收空格回车
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            new Main().stringSort(strings);
        }
        scanner.close();
    }

    /**
     * 解法一：用JavaAPI Arrays.sort()方法
     * 运行时间：228ms 占用内存：22040KB
     * @param strings
     */
    public void stringSort(String[] strings){
        Arrays.sort(strings);
        for(int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    /**
     * 解法二：
     * 遍历字符串数组，第一趟根据第一个字符先进行排序并分桶，第二趟每个桶内根据第二个字符进行排序
     * @param strings
     */
//    public void stringSort2(String[] strings){
//        int len = strings.length;
//        char[] chars = new char[len];
//        //把每个字符串的首位取出放在chars中
//        for (int i = 0; i < len; i++) {
//            chars[i] = strings[i].charAt(0);
//        }
//        System.out.println(Arrays.toString(chars));
//        //冒泡排序首位
//        for (int i = 0; i < chars.length - 1; i++) {
//            boolean flag = false;
//            for (int j = 1; j < chars.length - i; j++) {
//                if (chars[j] < chars[j - 1]){
//                    String tm = strings[j];
//                    strings[j] = strings[j-1];
//                    strings[j-1] = tm;
//                    char ctm = chars[j];
//                    chars[j] = chars[j - 1];
//                    chars[j - 1] = ctm;
//                    flag = true;
//                }
//            }
//            if (!flag){
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(strings));
//        for(int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
//        }
//    }

}
