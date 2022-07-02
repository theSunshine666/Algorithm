package com.company.wq.niuke.huawei.haxaToDecimal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            //解法一：直接用API Integer.parseInt()方法，传入的第二个参数即为进制数；
//            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
            Main main = new Main();
            //解法二：
            int result = main.haxaToDecimal(s);
            System.out.println(result);
            //解法三：
//            System.out.println(main.strToNum(s.substring(2)));
        }
        scanner.close();
    }

    /**
     * 解法二：利用map存储十六进制数，方便取值
     * 第一步：先截取数字部分（即除了前缀0x剩余的部分）；
     * 第二步：处理10-15，即从A-F
     * 第三步：乘16进行转换。
     * 如果不考虑A-F，如何转换
     * @param string
     * @return
     */
    public int haxaToDecimal(String string){
        String str = string.substring(2);
        int len = str.length();
        //用map的键值对存储0-15，方便获取值
        Map<Character,Integer> map = new HashMap();
        char[] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','a','b','c','d','e','f'};
        for (int i = 0; i < 16; i++) {
            map.put(ch[i],i);
        }
        for (int i = 10; i < 16; i++) {
            map.put(ch[i+6],i);
        }
        int res = 0;
        //解法2.1:正向
//        for (char c:str.toCharArray()) {
//            res = res * 16 + map.get(c);
//        }
        //解法2.2:逆向
        char[] c = str.toCharArray();
        int j = 0;
        for (int i = len - 1; i >= 0; i--) {
            res = (int) (map.get(c[i]) * Math.pow(16,j++) + res);
        }
        return res;
    }

    /**
     *
     * @param s
     * @return
     */
    public int strToNum(String s){
        int num = 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int t = 0;
            if (ch[i] >= '0' && ch[i] <= '9'){
                t = ch[i] - '0';
            }else if (ch[i] >= 'a' && ch[i] <= 'f'){
                t = ch[i] - 'a' + 10;
            }else if (ch[i] >= 'A' && ch[i] <= 'F'){
                t = ch[i] - 'A' + 10;
            }
            num = (int) (t * Math.pow(16,len - i - 1) + num);
        }
        return num;
    }
}
