package com.company.wq.niuke.huawei.unrepeatInteger;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Set<Integer> set = new HashSet();
            int target = in.nextInt();
            int result = 0;
            while (target != 0){
                int temp = target % 10;
                if (set.add(temp)){
                    result = (result * 10 + temp);
                }
                target /= 10;
            }
            System.out.println(result);
        }
        in.close();
    }
}
