package com.company.wq.niuke.huawei.removeFewestChar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = read.readLine())!=null && !str.equals("")){
            int[] count = new int[26];
            char[] chars = str.toCharArray();
            for (char c :chars) {
                count[c-'a']++;
            }
            int min = chars[0] - 'a';
            //找到最小值的下标，也就是找到了最小值count[min],最少数量的字符即为min+'a'
            for (int i = 1; i < 26; i++) {
                if (count[i] != 0 && count[i] < count[min]){
                    min = i;
                }
            }
            String newString = str;
            //用空字符替换字符串中的min+'a'
            for (int i = 0; i < str.length(); i++) {
                if (count[chars[i]-'a'] == count[min]){
                    newString = newString.replaceAll(String.valueOf(chars[i]),"");
                }
            }
            System.out.println(newString);
        }
    }
}
