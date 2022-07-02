package com.company.wq.niuke.huawei.takeApproximation;

import java.util.Scanner;

public class Main {

    /**
     * 本题考察浮点型数字强转成int型数字会直接去掉小数点后的部分
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()){
            double d = in.nextDouble();
            System.out.println("解法一："+(int)(d+0.5));
            System.out.println("(int)d="+(int)d);
            System.out.println("解法二："+((d-(int)d)>=0.5 ? (int)(d+1) : (int)d));
            System.out.println("解法三："+(int)Math.round(d));
        }
        in.close();
    }
}
