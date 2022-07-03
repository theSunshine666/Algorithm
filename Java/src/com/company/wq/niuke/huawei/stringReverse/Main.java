package com.company.wq.niuke.huawei.stringReverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            Main main = new Main();
            String result = main.stringReverse3(str);
            System.out.println(result);
        }
        scanner.close();
    }

    /**
     * 解法一：
     * 直接用StringBuilder的reverse方法
     * 运行时间：50ms 占用内存：10900KB
     * @param str
     * @return
     */
    public String stringReverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 解法二：
     * 用循环遍历字符串的方法反转
     * 运行时间：51ms 占用内存：12876KB
     * @param str
     * @return
     */
    public String stringReverse2(String str){
        String result = "";
        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    /**
     * 解法三：推荐用
     * 将字符串对着交换
     * 运行时间：37ms 占用内存：10864KB
     * @param str
     * @return
     */
    public String stringReverse3(String str){
        char[] chars = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = temp;
        }
        return new String(chars);
    }
}
