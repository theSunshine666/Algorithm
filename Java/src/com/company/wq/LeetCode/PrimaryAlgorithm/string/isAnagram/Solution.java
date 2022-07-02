package com.company.wq.LeetCode.PrimaryAlgorithm.string.isAnagram;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 */

public class Solution {
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        Solution solution = new Solution();
        System.out.println(solution.isAnagram2(s2,t2));

    }

    //两次遍历记录每个字母出现的次数
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()){
            return false;
        }
        int[] sInt = new int[26];
        int[] tInt = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < len; i++) {
            sInt[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < len; i++) {
            tInt[t.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if (sInt[i] != tInt[i]){
                return false;
            }
        }
        return true;
    }

    //先排序再比较
    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        for (int i = 0; i < s.length(); i++) {
            if (sChar[i] != tChar[i]){
                return false;
            }
        }
        return true;
    }
}
