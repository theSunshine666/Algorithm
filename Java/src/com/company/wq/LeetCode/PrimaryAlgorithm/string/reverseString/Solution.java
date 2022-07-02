package com.company.wq.LeetCode.PrimaryAlgorithm.string.reverseString;

public class Solution {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        char[] s2 = {'H','a','n','n','a','h'};
        new Solution().reverseString2(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    //解法一：对称交换
    public void reverseString(char[] s){
        char temp;
        for (int i = 0; i < s.length / 2; i++){
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    //解法二：双指针法
    public void reverseString2(char[] s){
        int left=0,right=s.length-1;
        while(left<right){
            swap(s,left++,right--);
        }
    }

    public void swap(char[] s,int left,int right){
        char temp;
        temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
