package com.company.wq.niuke.huawei.simpleErroLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wq
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        Map<String, Integer> map = new LinkedHashMap<>();
        while ((str = bufferedReader.readLine()) != null && !str.equals("")) {
            //1、用空格把路径和行数分开
            String[] strings = str.split("\\s+");
            //2、用\把文件名取出来，不带行号
            String fileName = strings[0].substring(strings[0].lastIndexOf('\\') + 1);
            //3、处理长度超过16的文件名，当作map的key值，为了方便，可以把行号也当成文件名的一部分
            //第一种解法：用if判断
//            String key;
//            if (fileName.length() > 16){
//                key = fileName.substring(fileName.length() - 16) + strings[1];
//            }else {
//                key = fileName + strings[1];
//            }
            //第二种解法：用max
            String key = fileName.substring(Math.max(fileName.length() - 16, 0)) + " " + strings[1];
            //第三种解法：用三元运算？：
//            String key = fileName.substring((fileName.length() - 16) > 0 ? (fileName.length() - 16) : 0) + " " + strings[1];
            //4、往map中存，以<key,value>的形式，value是key出现的次数，也就是相同文件名和行号
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            if (map.size() - count <= 8) {
                System.out.println(i.getKey() + " " + i.getValue());
            }
            count++;
        }
    }

    /**
     * 1、用空格把路径和行数分开
     * 2、用\把文件名取出来
     * 3、处理长度超过16的文件名
     * @param string
     */
}
