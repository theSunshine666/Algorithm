package com.company.wq.niuke.huawei.stringLastWordLen;

import java.util.Scanner;

/**
 * @author wq
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
//        int result1 = new Solution().stringLastWordLength(s);
//        int result2 = new Solution().stringLastWordLength2(s);
//        int result3 = new Solution().stringLastWordLength3(s);
//        System.out.println(result1+"==="+result2+"==="+result3);
//        System.out.println(s.substring(s.lastIndexOf(' ')+1).length());
        System.out.println(new Solution().stringLastWordLength4(s));
        scanner.close();
    }

    /**
     * 解法一：利用split将字符床用空格分割成数组，计算最后一个字符串数组的长度即可
     * 运行时间：38ms 占用内存：10876KB
     */
    public int stringLastWordLength(String string){
        if ("".equals(string)){
            return 0;
        }
        String[] str = string.split(" ");
        return str[str.length-1].length();
    }

    /**
     * 解法二：直接从最后一个字符往前查找空字符
     * 运行时间：37ms 占用内存：10880KB
     * @param string 目的字符串
     * @return 返回字符串长度
     */
    public int stringLastWordLength2(String string){
        int result = 0;
        for (int i = string.length()-1; i >= 0; i--) {
            if (string.charAt(i) != ' '){
                result++;
            }else {
                return result;
            }
        }
        return result;
    }

    /**
     * 解法三：用String的substring方法截取最后一段字符串
     * 运行时间：40ms 占用内存：10816KB
     * @param string
     * @return
     */
    public int stringLastWordLength3(String string){
        String s = string.substring(string.lastIndexOf(' ')+1);
        return s.length();
    }

    /**
     * 解法四：用String的lastIndexOf定位最后一个空格的位置，然后用总长度减去最后一个空格位置下标再减1
     * 即最后一个字符串的长度
     * 运行时间：45ms 占用内存：10828KB
     */
    public int stringLastWordLength4(String string){
        int i = string.lastIndexOf(' ');
        return string.length() - i - 1;
    }
}
