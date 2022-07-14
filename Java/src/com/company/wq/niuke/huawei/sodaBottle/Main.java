package com.company.wq.niuke.huawei.sodaBottle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null && !str.equals("0") && !str.equals("")){
//            int num = Integer.parseInt(str);
//            int count = num / 3;
//            System.out.println(count + (count + num % 3) / 2);
            System.out.println(Integer.parseInt(str) / 2);
        }
    }
}