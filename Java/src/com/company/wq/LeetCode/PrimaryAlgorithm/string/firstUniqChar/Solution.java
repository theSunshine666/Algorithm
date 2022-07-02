package com.company.wq.LeetCode.PrimaryAlgorithm.string.firstUniqChar;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = new Solution().firstUniqChar2(s);
        System.out.println(result);
    }

    //两次遍历
    public int firstUniqChar(String s) {
        int len = s.length();
        int visit[] = new int[26];
        char[] ch = s.toCharArray();

        for (int i = 0; i < len; i++) {
            visit[ch[i]-'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (visit[ch[i]-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    //使用Java API
    public int firstUniqChar2(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
