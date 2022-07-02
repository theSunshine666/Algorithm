package com.company.wq.niuke.huawei.mergeTableRecord;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        解法一：直接用key，value进行接受输入的值，边接收边往map中加入
//        Scanner scanner = new Scanner(System.in);
//        int tableSize = scanner.nextInt();
//        Map<Integer, Integer> table = new HashMap<>(tableSize);
//        for (int i = 0; i < tableSize; i++) {
//            int key = scanner.nextInt();
//            int value = scanner.nextInt();
//            if (table.containsKey(key)) {
//                table.put(key, table.get(key) + value);
//            } else {
//                table.put(key, value);
//            }
//        }
//        for (Integer key : table.keySet()) {
//            System.out.println( key + " " + table.get(key));
//        }

        //解法二：创建二维数组接收输入的值，然后用mergeTable方法
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] table = new int[n][2];
            for (int i = 0; i < n; i++) {
                table[i][0] = sc.nextInt();
                table[i][1] = sc.nextInt();
            }
            Main main = new Main();
            main.mergeTable2(n,table);
        }
        sc.close();

    }

    /**
     * 创建map的时候指定大小
     * @param n
     * @param table
     */
    public void mergeTable(int n,int[][] table){
        //指定map的大小以后会根据key值进行排序，不指定的话不会排序？
        Map<Integer,Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(table[i][0])){
                map.put(table[i][0],map.get(table[i][0]) + table[i][1]);
            }else {
                map.put(table[i][0],table[i][1]);
            }
        }
        //map.keySet是获取map的key值
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    /**
     * 创建map的时候不指定大小，输出时不会根据key进行排序，因此要进行手动排序key
     * @param n
     * @param table
     */
    public void mergeTable2(int n,int[][] table){
        Map<Integer,Integer> map = new HashMap<>();
        //根据key相同的，对value进行合并
        for (int i = 0; i < n; i++) {
            if (map.containsKey(table[i][0])){
                map.put(table[i][0],map.get(table[i][0]) + table[i][1]);
            }else {
                map.put(table[i][0],table[i][1]);
            }
        }
        //keySet():该方法返回map中所有key值的列表
        Set set = map.keySet();
        //set.toArray()返回的是Object数组类型
        Object[] array = set.toArray();
        //排序key
        Arrays.sort(array);
        //新建newMap存放排序后的map
        Map newMap = new HashMap();
        //map.keySet是获取map的key值
        for (Object key : array) {
            newMap.put(key,map.get(key));
            System.out.println(key + " " + newMap.get(key));
        }
    }
}
