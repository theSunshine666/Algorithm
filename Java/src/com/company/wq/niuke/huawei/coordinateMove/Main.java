package com.company.wq.niuke.huawei.coordinateMove;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            coordinateMove(string);
        }
        scanner.close();
    }

    public static void coordinateMove(String string){
        //用分号将字符串分割成字符串数组，分成的每个字符串代表一个移动
        String[] str = string.split(";");
        int x = 0, y = 0;
        //定义nums数组存储移动的距离
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() <= 1){
                nums[i] = 0;
            }else if (str[i].length() > 3){
                nums[i] = 0;
            }else if (str[i].length() == 3){
                if (str[i].charAt(1) > '9' || str[i].charAt(1) < '0' ||
                        str[i].charAt(2) > '9' || str[i].charAt(2) < '0'){
                    nums[i] = 0;
                }else {
                    nums[i] = Integer.parseInt(str[i].substring(1));
                }
            }else {
                if (str[i].charAt(1) > '9' || str[i].charAt(1) < '0'){
                    nums[i] = 0;
                }else {
                    nums[i] = Integer.parseInt(str[i].substring(1));
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() != 0){
                switch (str[i].charAt(0)){
                    case 'A':
                        x -= nums[i];
                        break;
                    case 'D':
                        x += nums[i];
                        break;
                    case 'W':
                        y += nums[i];
                        break;
                    case 'S':
                        y -= nums[i];
                        break;
                    default:
                }
            }

        }
        System.out.println(x+","+y);
    }

    public static void coordinateMove2(String string){
        String[] str = string.split(";");
        int x = 0, y = 0;
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            if (!str[i].matches("^[WASD][0-9]{1,2}")){
                continue;
            }
            nums[i] = Integer.parseInt(str[i].substring(1));
            switch (str[i].charAt(0)){
                case 'A':
                    x -= nums[i];
                    break;
                case 'D':
                    x += nums[i];
                    break;
                case 'W':
                    y += nums[i];
                    break;
                case 'S':
                    y -= nums[i];
                    break;
                default:
            }
        }
        System.out.println(x+","+y);
    }
}
