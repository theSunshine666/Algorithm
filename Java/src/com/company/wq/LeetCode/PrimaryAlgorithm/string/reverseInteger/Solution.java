package com.company.wq.LeetCode.PrimaryAlgorithm.string.reverseInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse1(1534236462));
    }

    public int reverse1(int x){
        int result = 0;
        while(x != 0){
            int t = x % 10;
            int newResult = result * 10 + t;
            if ((newResult - t) / 10 != result){
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }

//    public int reverse(int x){
//        String str;
//        long temp = (int)x;
//        System.out.println(Integer.MAX_VALUE+""+Integer.MIN_VALUE+"\n"+temp+(temp>Integer.MAX_VALUE));
//        if (x == 0){
//            return 0;
//        }else if (x > 0){
//            str = x + "";
//        }else {
//            str = (x + "").replace("-","");
//        }
//
//        int len = str.length();
//        if (len == 10 && (x % 10) > 2){
//            return 0;
//        }
//        String s = "1";
//        for (int i = 0; i < len - 1; i++) {
//            s += "0";
//        }
//        int highest = Integer.parseInt(s);
//
//        int[] num = new int[len];
//        for (int i = 0; i < len; i++) {
//            num[i] = x / highest;
//            x -= num[i]*highest;
//            highest /= 10;
//        }
//
//        int result = 0;
//        highest = 1;
//        for (int i = 0; i < len; i++) {
//            result += num[i] * highest;
////            System.out.println("当前result是："+result+"\n当前highest是："+highest+"\nnum[i]="+num[i]);
//            highest *= 10;
//        }
//        return result;
//    }
}
