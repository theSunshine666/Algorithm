package com.company.wq.datastructure.HashMap;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("test", 1);  //往map中存储键值对
        map.put("test2", 2);
        map.put("test3", 3);
        map.put("test4", 4);
        System.out.println(map);
        System.out.println("map的数量" + map.size());  //map的大小，存储内容的数量
        System.out.println("test对应的value值为" + map.get("test"));  //通过key值获取value值
        System.out.println("========通过keySet()获取key值=========");
        Set<String> keys = map.keySet();  //通过keySet()获取key值
        for (String s : keys) {
            System.out.println(s);
        }
        System.out.println("========containsKey和containsValue=========");
        System.out.println("map中是否包含key=test" + map.containsKey("test"));
        System.out.println("map中是否包含value=1" + map.containsValue(1));
        System.out.println("===========getOrDefault()查找map中是否有指定的key值，有则返回key对应的value值，没有则返回指定的第二个参数============");
        System.out.println(map.getOrDefault("test", 0));
        System.out.println(map.getOrDefault("test5", 0));

        System.out.println("=========第一种：用entrySet()来遍历map，推荐，尤其容量大时========");
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println("key=" + m.getKey() + ",value=" + m.getValue());
        }
        System.out.println("=========第二种：用keySet()来遍历map========");
        for (String s : map.keySet()) {
            System.out.println("key=" + s + ",value=" + map.get(s));
        }
        System.out.println("=========第三种：用entrySet的iterator========");
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
        }
        System.out.println("=========第四种：用map.values()遍历所有的value，但不能遍历key========");
        for (Integer v : map.values()) {
            System.out.println("value=" + v);
        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            //直接将String换成Character类型也行，不过下面就要改了
            Map<String,Integer> map1 = new HashMap<>();
            for (char c: s.toCharArray()) {
                //下面不用将c转换为字符串了，要注意的是getOrDefault这个方法的第一个参数要根Map的key参数保持一致
                map1.put(String.valueOf(c),map1.getOrDefault(String.valueOf(c),0)+1);
            }
            System.out.println(map1);
        }
        scanner.close();
    }
}
