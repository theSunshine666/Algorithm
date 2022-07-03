package com.company.wq.niuke.huawei.sentenceReverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            Main main = new Main();
            String result = main.sentenceReverse2(str);
            System.out.println(result);
        }
        scanner.close();
    }

    /**
     * 解法一：
     * 用split方法将句子用空格分割成字符串数组，然后将字符串数组逆序拼接到新的空字符串上
     * 运行时间：50ms 占用内存：11044KB
     * @param str
     * @return
     */
    public String sentenceReverse(String str){
        String result = "";
        String[] words = str.split(" ");
        int i;
        for (i = words.length - 1; i > 0; i--) {
            result += words[i] + " ";
        }
        return result + words[i];
    }

    /**
     * 解法二：未使用split方法，时间复杂度低
     * 字符串从后往前遍历，并存入到临时字符串temp中，遇到空格就将temp反转，并将temp重置为空
     * 需要注意的是：当遍历完后，输入的第一个单词还没有反转，因为第一个单词前面没有空格，需要
     * 返回的时候再调用一次字符串反转的方法并拼接到结果字符串上。
     * 运行时间：38ms 占用内存：11208KB
     * @param str
     * @return
     */
    public String sentenceReverse2(String str){
        String result = "";
        String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' '){
                temp += str.charAt(i);
            }else {
                result += stringReverse3(temp) + " ";
                temp = "";
            }
        }
        return result + stringReverse3(temp);
    }

    /**
     * 反转字符串
     * @param str
     * @return
     */
    private String stringReverse3(String str){
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
