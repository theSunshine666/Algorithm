package com.company.wq.niuke.huawei.shoppingCar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 * 王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件，且每件物品只能购买一次。
 * 每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强查到了每件物品的价格（都是 10 元的整数倍），而他只有 N 元的预算。除此之外，他给每件物品规定了一个重要度，用整数 1 ~ 5 表示。他希望在花费不超过 N 元的前提下，使自己的满意度达到最大。
 * 满意度是指所购买的每件物品的价格与重要度的乘积的总和，假设设第ii件物品的价格为v[i]v[i]，重要度为w[i]w[i]，共选中了kk件物品，编号依次为j_1,j_2,...,j_k，则满意度为:
 * v[j1]*w[j1]+v[j2]*w[j2]+...+v[jk]*w[jk]，其中*为乘号
 * 链接：https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&tqId=21239&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * 请你帮助王强计算可获得的最大的满意度。
 * @author wq
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N3 = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] list3 = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    list3[i][j] = scanner.nextInt();
                }
            }
            System.out.println(maxValueShop(list3, N3));
        }
        scanner.close();
    }

    public static int maxValueShop(int[][] list, int N) {
        int len = list.length;
        int[] v = new int[len + 1];
        int[] p = new int[len + 1];
        int[] q = new int[len + 1];
        Goods[] goods = new Goods[len + 1];
        //初始化v，p，q，goods
        goods[0] = new Goods(0,0,0);
        for (int i = 1; i < len + 1; i++) {
            v[i] = list[i - 1][0];
            p[i] = list[i - 1][1];
            q[i] = list[i - 1][2];
            goods[i] = new Goods(v[i], p[i], q[i]);
        }
        //对附件进行处理，如果该物品是附件，那么将该附件对应到主件上去
        for (int i = 1; i < len + 1; i++) {
            if (goods[i].q > 0) {
                if (goods[goods[i].q].a1 == 0) {
                    goods[goods[i].q].setA1(i);
                }else if (goods[goods[i].q].a2 == 0) {
                    goods[goods[i].q].setA2(i);
                }
            }
        }
        //到这里都是没有问题的
        int cardinality = getCardinality(v); //基数
        //dp[i][j]代表的是：手中有j元时，买第i件物品时达到的最大满意度是dp[i][j]
        int[][] dp = new int[len + 1][N /cardinality+ 1];
        for (int i = 1; i < len + 1; i++) {
            int price = 0, price1 = 0, price2 = 0, price3 = 0;
            int satisfy = 0, satisfy1 = 0, satisfy2 = 0, satisfy3 = 0;
            //只考虑主件
            price = goods[i].v;
            satisfy = goods[i].v * goods[i].p;

            //买主件+附件一
            if (goods[i].a1 > 0) {
                price1 = goods[goods[i].a1].v + price;
                satisfy1 = goods[goods[i].a1].v * goods[goods[i].a1].p + satisfy;
            }
            //买主件+附件二
            if (goods[i].a2 > 0 ) {
                price2 = goods[goods[i].a2].v + price;
                satisfy2 = goods[goods[i].a2].v * goods[goods[i].a2].p + satisfy;
            }
            //买主件+附件一+附件二
            if (goods[i].a1 > 0 && goods[i].a2 > 0) {
                price3 = goods[goods[i].a1].v + goods[goods[i].a2].v + price;
                satisfy3 = goods[goods[i].a1].v * goods[goods[i].a1].p + goods[goods[i].a2].v * goods[goods[i].a2].p + satisfy;
            }
            //对dp进行赋值（填充表格）
            for (int j = 1; j <= N/cardinality; j++) {
                if (goods[i].q > 0) { //跳过附件
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //只买主件，对应上面price和satisfy
                    if (j * cardinality >= price && price != 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j * cardinality - price) / cardinality] + satisfy);
                    }
                    //买主件+附件一，对应上面price1和satisfy1
                    if (j * cardinality >= price1 && price1 != 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j * cardinality - price1) / cardinality] + satisfy1);
                    }
                    //买主件+附件二，对应上面price2和satisfy2
                    if (j * cardinality >= price2 && price2 != 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j * cardinality - price2) / cardinality] + satisfy2);
                    }
                    //买主件+附件一+附件二，对应上面price3和satisfy3
                    if (j * cardinality >= price3 && price3 != 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j * cardinality - price3) / cardinality] + satisfy3);
                    }
                }
            }
        }
        return dp[len][N/cardinality];
    }


    public static int getCardinality(int[] arr){
        int[] arrCopy = arr;
        Arrays.sort(arrCopy);
        int temp = arrCopy[1];
        int count = 1;
        while (temp / 10 != 0){
            temp /= 10;
            count *= 10;
        }
        return count;
    }
}

class Goods {
    int v; //价格
    int p; //重要度
    int q; //是否为附件

    int a1 = 0, a2 = 0;

    public Goods(int v, int p, int q) {
        this.v = v;
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "v=" + v +
                ", p=" + p +
                ", q=" + q +
                ", a1=" + a1 +
                ", a2=" + a2 +
                '}';
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }
}

/**
 未通过的示例一：
 50 5
 20 3 5  这个
 20 3 5  这个
 10 3 0
 10 2 0
 10 1 0  这个
 预期输出：130
 未通过的示例二：
 1000 5
 800 2 0   这个
 400 5 1
 200 5 1   这个
 400 3 0
 500 2 0
 预期输出：2600
 未通过的示例三：
 2000 10
 500 1 0  这个
 400 4 0
 300 5 1  这个
 400 5 1  这个
 200 5 0  这个
 500 4 5
 400 4 0
 320 2 0
 410 3 0  这个
 400 3 5  这个
 预期输出：7430  这个应该是题目测试用例答案错了，实际输出应该是7400
 10 5 4
 10 5 4
 10 5 0
 10 1 0
 输出：110
 */
