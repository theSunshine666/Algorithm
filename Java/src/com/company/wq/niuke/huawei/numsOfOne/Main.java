package com.company.wq.niuke.huawei.numsOfOne;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            System.out.println(Main.NumsOf13(num));
        }
        scanner.close();
    }

    /**
     * 解法一：
     * 先把十进制数字转成二进制数字的字符串，再将字符串中的“1”全部替换为空，
     * 再让替换前字符串的长度减去替换后字符串的长度就是1的个数
     * @param num
     * @return
     */
    public static int NumsOf1(int num){
        String str = Integer.toBinaryString(num);
        return str.length()-str.replaceAll("1","").length();
    }

    /**
     * 解法二：与运算
     * 因为与运算&是将数字转换为二进制后再进行运算的，两者都为1结果为1，有一个为0则结果为0，
     * 可以让数字与1进行与运算，然后无符号右移
     * 不断重复这个过程就能得到1的个数
     * @param num
     * @return
     */
    public static int NumsOf12(int num){
        int count = 0;
        while (num!=0){
            if ((num&1)==1){
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }

    /**
     * 解法三：除二取余法
     * 根据十进制转二进制的算法，除二余数为1，则累加1的个数
     * @param num
     * @return
     */
    public static int NumsOf13(int num){
        int count = 0;
        while (num != 0){
            if (num % 2 == 1){
                count++;
            }
            num /= 2;
        }
        return count;
    }
}
