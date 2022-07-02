package com.company.wq.datastructure.slideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String string = "abcbacdca";
        int len = new Main().slideWindow(string);
        System.out.println(len);
    }

//    public int slideWindowModel(String s){
        //最长模板
//        初始化left，right，result，bestResult；
//        while(右指针没有到结尾){
//            窗口扩大，加入right对应元素，更新当前result;
//            while (result不满足要求){
//                窗口缩小，移除left对应元素，left右移;
//            }
//            更新最优结果bestResult;
//            right++;
//        }
//        return bestResult;

        //最短模板
//        初始化left，right，result，bestResult；
//        while(右指针没有到结尾){
//            窗口扩大，加入right对应元素，更新当前result;
//            while (result满足要求){
//                更新最优结果bestResult;
//                窗口缩小，移除left对应元素，left右移;
//            }
//            right++;
//        }
//        return bestResult;
//    }

    /**
     * 3.无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return
     */
    public int slideWindow(String s){
        int curr_len = 0, max_len = 0;
        int left = 0, right = 0;
        Set set =new HashSet();
        while (right < s.length()){
            if (set.add(s.charAt(right))){
                curr_len++;
                max_len = Math.max(curr_len,max_len);
                right++;
            }else {
                while (!set.add(s.charAt(right))){
                    set.remove(s.charAt(left));
                    curr_len--;
                    left++;
                }
                set.add(s.charAt(right));
                curr_len++;
                right++;
            }
        }
        return max_len;
    }
}
