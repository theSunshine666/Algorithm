package com.company.wq.niuke.huawei.characterNum;

import java.util.Scanner;

/**
 *描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 输入：
 * ABCabc
 * A
 * 输出：
 * 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().toLowerCase();
        //读取char类型要先获取String类型的，然后用charAt()方法转化为char
        char c1 = scanner.next().toLowerCase().charAt(0);
//        System.out.println(new Main().characterNum(s1,c1));
        System.out.println(new Main().characterNum2(s1,c1));
        scanner.close();
    }

    /**
     * 解法一：
     * 使用String的equalsIgnoreCase()方法，即忽略大小写比较
     * String.valueOf()方法是将char类型的字符转换为String类型
     * 运行时间：44ms 占用内存：11040KB
     * @param s
     * @param c
     * @return
     */
    public int characterNum(String s,char c){
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(c))){
                result++;
            }
        }
        return result;
    }

    /**
     * 解法二：长度相减法
     * 使用String的replaceAll()方法，将c全部替换成空字符串，然后用总长度减去替换后的长度即为字符c的个数
     * 前提是将要传进来的字符串全部转换为小写或者大写
     * 运行时间：39ms 占用内存：10812KB
     * @param s
     * @param c
     * @return
     */
    public int characterNum2(String s,char c){
        return s.length() - s.replaceAll(String.valueOf(c),"").length();
    }
}
