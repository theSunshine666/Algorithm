package com.company.wq.niuke.huawei.characterCount;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Main main = new Main();
            String string = sc.nextLine();
            int result = main.countCharacter2(string);
            System.out.println(result);
        }
        sc.close();
    }

    /**
     * 因为题目要求统计0-127之间（包含0和127）的字符，因此可以用长度为128的数组chars
     * 记录这128个字符出现的次数,因为数组初始化的时候为0，不为0则表示出现了，就让count+1
     * @param string
     * @return
     */
    public int countCharacter2(String string){
        int[] chars = new int[128];
        int count = 0;
        char[] s = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            chars[s[i] - 0]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0){
                count++;
            }
        }
        return count;
    }

    /**
     * 利用HashSet的不重复性质，存入hashSet中的字符即为不重复的字符，hashSet的大小即字符的数量
     * @param string
     * @return
     */
    public int countCharacter(String string){
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            hashSet.add(string.charAt(i));
        }
        return hashSet.size();
    }
}
