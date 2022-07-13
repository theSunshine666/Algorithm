package com.company.wq.niuke.huawei.isValidIPAndMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int a = 0, b = 0, c = 0, d = 0, e = 0, erroIP = 0, privateIP = 0;
        while ((input = bf.readLine()) != null && !input.equals("")) {
            String[] ipAndMask = input.split("\\~");
            String ip = ipAndMask[0];
            String mask = ipAndMask[1];
            int ip1 = Integer.parseInt(ip.split("\\.")[0]);

            if (ip1 == 0 || ip1 == 127) {
                continue;
            } else {
                if (!isValidIP(ip)) {
                    erroIP++;
                } else if (!isValidMask(mask)) {
                    erroIP++;
                } else {
                    int ip2 = Integer.parseInt(ip.split("\\.")[1]);
                    if (ip1 >= 1 && ip1 <= 126) {
                        if (ip1 == 10) {
                            privateIP++;
                            a++;
//                            System.out.println(ip+"是一个A类的IP地址");
                        } else {
                            a++;
                        }
                    } else if (ip1 >= 128 && ip1 <= 191) {
                        if (ip1 == 172 && (ip2 >= 16 && ip2 <= 31)) {
                            privateIP++;
                            b++;
                        } else {
                            b++;
                        }
                    } else if (ip1 >= 192 && ip1 <= 223) {
                        if (ip1 == 192 && ip2 == 168) {
                            privateIP++;
                            c++;
                        } else {
                            c++;
                        }
                    } else if (ip1 >= 224 && ip1 <= 239) {
                        d++;
                    } else if (ip1 >= 240 && ip1 <= 255) {
                        e++;
                    }
                }
            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + erroIP + " " + privateIP);
    }

    private static boolean isValidMask(String mask) {
        if (!isValidIP(mask)){
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] masks = mask.split("\\.");
        for (int i = 0; i < masks.length; i++) {
            masks[i] = Integer.toBinaryString(Integer.parseInt(masks[i]));
            if (masks[i].length() < 8){
                for (int j = 0; j < 8 - masks.length; j++) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(masks[i]);
            }else {
                stringBuilder.append(masks[i]);
            }
        }
        return stringBuilder.lastIndexOf("1") < stringBuilder.indexOf("0");
    }

    public static boolean isValidIP(String ip) {
        String[] ips = ip.split("\\.");
        int[] nums = new int[ips.length];
        if (ips.length != 4) {
            return false;
        } else {
            for (int i = 0; i < ips.length; i++) {
                nums[i] = Integer.parseInt(ips[i]);
                if (nums[i] < 0 || nums[i] > 255) {
                    return false;
                }
            }
        }
        return true;
    }
}

//        225.240.129.203~255.110.255.255   错误的子网掩码
//        183.181.49.4~255.0.0.0            B类地址
//        172.177.113.45~255.0.0.0          B类地址，私有地址
//        176.134.46.246~255.0.0.0          B类地址
//        153.63.21.56~255.255.58.255       错误的子网掩码
//        23.135.167.228~255.0.0.0          A类地址
//        204.58.47.149~255.0.0.0           C类地址
//        113.33.181.46~255.255.255.0       A类
//        73.245.52.119~255.255.154.0       错误的子网掩码
//        23.214.47.71~255.0.0.0            A类地址
//        139.124.188.91~255.255.255.100    错误的子网掩码
//        142.94.192.197~255.0.0.0          B类地址
//        53.173.252.202~255.0.0.0          A类地址
//        127.201.56.50~255.255.111.255     错误的子网掩码
//        118.251.84.111~255.0.0.0
//        130.27.73.170~255.0.0.0
//        253.237.54.56~255.86.0.0
//        64.189.222.111~255.255.255.139
//        148.77.44.147~255.0.0.0
//        59.213.5.253~255.255.0.0
//        3.52.119.131~255.255.0.0
//        213.208.164.145~255.255.0.0
//        24.22.21.206~255.255.90.255
//        89.43.34.31~255.0.0.0
//        9.64.214.75~255.0.0.0
//        110.156.20.173~255.153.0.0
//        71.183.242.53~255.255.0.0
//        119.152.129.100~255.0.0.0
//        38.187.119.201~255.0.0.0
//        73.81.221.180~255.255.255.255
//        73.198.13.199~255.0.15.0
//        99.42.142.145~255.255.255.0
//        196.121.115.160~255.0.0.0
//        226.30.29.206~255.0.0.0
//        244.248.31.171~255.255.255.255
//        59.116.159.246~255.0.0.0
//        121.124.37.157~255.0.0.226
//        103.42.94.71~255.255.0.0
//        125.88.217.249~255.255.74.255
//        73.44.250.101~255.255.255.0

/**
 * 225.240.129.203~255.110.255.255
 * 183.181.49.4~255.0.0.0
 * 172.177.113.45~255.0.0.0
 * 176.134.46.246~255.0.0.0
 * 153.63.21.56~255.255.58.255
 * 23.135.167.228~255.0.0.0
 * 204.58.47.149~255.0.0.0
 * 113.33.181.46~255.255.255.0
 * 73.245.52.119~255.255.154.0
 * 23.214.47.71~255.0.0.0
 * 139.124.188.91~255.255.255.100
 * 142.94.192.197~255.0.0.0
 * 53.173.252.202~255.0.0.0
 * 127.201.56.50~255.255.111.255
 * 118.251.84.111~255.0.0.0
 * 130.27.73.170~255.0.0.0
 * 253.237.54.56~255.86.0.0
 * 64.189.222.111~255.255.255.139
 * 148.77.44.147~255.0.0.0
 * 59.213.5.253~255.255.0.0
 * 3.52.119.131~255.255.0.0
 * 213.208.164.145~255.255.0.0
 * 24.22.21.206~255.255.90.255
 * 89.43.34.31~255.0.0.0
 * 9.64.214.75~255.0.0.0
 * 110.156.20.173~255.153.0.0
 * 71.183.242.53~255.255.0.0
 * 119.152.129.100~255.0.0.0
 * 38.187.119.201~255.0.0.0
 * 73.81.221.180~255.255.255.255
 * 73.198.13.199~255.0.15.0
 * 99.42.142.145~255.255.255.0
 * 196.121.115.160~255.0.0.0
 * 226.30.29.206~255.0.0.0
 * 244.248.31.171~255.255.255.255
 * 59.116.159.246~255.0.0.0
 * 121.124.37.157~255.0.0.226
 * 103.42.94.71~255.255.0.0
 * 125.88.217.249~255.255.74.255
 * 73.44.250.101~255.255.255.0
 * 16 6 3 1 0 13 0
 */
