package com.company.wq.niuke.huawei.shoppingCar;

import java.util.Arrays;

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
        int[][] list = { {20,3,5},{20,3,5},{10,3,0},{10,2,0},{10,1,0} };
        int N = 50;
        System.out.println(maxValueShop(list,N));
    }

    /**
     * 分四种情况，只买主件，买主件+附件1，主件+附件2，主件+附件1+附件2
     * 类goods中，用a1表示附件1，a2表示附件2
     * 遍历遇到附件直接跳过，将附件放到主件中去考虑
     * @param list
     * @param N
     * @return
     */
    public static int maxValueShop(int[][] list,int N){
        //先初始化
        int len = list.length;
        N /= 10;
        int[] v = new int[len+1]; //价格
        int[] p = new int[len+1];  //重要度
        int[] q = new int[len+1];    //是否为附件

        Goods[] goods = new Goods[len+1];
        goods[0] = new Goods(0,0,0);
        for (int i = 1; i < len + 1; i++) {
            v[i] = list[i - 1][0];
            p[i] = list[i - 1][1];
            q[i] = list[i - 1][2];
            goods[i] = new Goods(v[i], p[i], q[i]);
        }
        for (int i = 1; i < len + 1; i++) {
            //list[i]为附件,q[i]为主件编号，因此将主件编号为q[i]的附件设置为当前物品编号
            if (q[i] > 0){
                if (goods[q[i]].a1 == 0){
                    goods[q[i]].setA1(i);
                }else {
                    goods[q[i]].setA2(i);
                }
            }
        }

        //dp[i][j]表示，手中money=j时，买第i件物品能够获得的最大满意度
        int[][] dp = new int[len+1][N+1];
        for (int i = 1; i < len+1; i++) {
            int v1 = 0,v2 = 0,v3 = 0;
            int temp1 = 0,temp2 = 0,temp3 = 0;

            //当前物品的满意度为
            int currItem = goods[i].v * goods[i].p;
            //只买附件1+主件，因为附件a1初始化为0，一旦不为0则说明上面已经将a1赋值为附件编号了
            if (goods[i].a1 != 0){
                v1 = goods[i].v + goods[goods[i].a1].v;
                temp1 = goods[goods[i].a1].p * goods[goods[i].a1].v + currItem;
            }
            //只买附件2+主件
            if (goods[i].a2 != 0){
                v2 = goods[i].v + goods[goods[i].a2].v;
                temp2 = goods[goods[i].a2].p * goods[goods[i].a2].v + currItem;
            }
            //买主件+附件1+附件2
            if (goods[i].a1 != 0 && goods[i].a2 != 0){
                v3 = goods[i].v + goods[goods[i].a1].v + goods[goods[i].a2].v;
                temp3 = goods[goods[i].a1].p * goods[goods[i].a1].v +
                        goods[goods[i].a2].p * goods[goods[i].a2].v + currItem;
            }
            for (int j = 1; j <= N; j++) {
                if (goods[i].q > 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                    //只买主件，没有附件
                    if (j*10 >= goods[i].v && goods[i].v != 0){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][(j*10-goods[i].v)/10]+currItem);
                    }
                    //买主件+附件1
                    if (j*10 >= v1 && v1 != 0){
                        dp[i][j] = Math.max(dp[i][j] = dp[i-1][j],dp[i-1][(j*10-goods[i].v-goods[goods[i].a1].v)/10]+temp1);
                    }
                    //买主件+附件2
                    if (j*10 >= v2 && v2 != 0){
                        dp[i][j] = Math.max(dp[i][j] = dp[i-1][j],dp[i-1][(j*10-goods[i].v-goods[goods[i].a2].v)/10]+temp2);
                    }
                    //买主件+附件1+附件2
                    if (j*10 >= v3 && v3 != 0){
                        dp[i][j] = Math.max(dp[i][j] = dp[i-1][j],dp[i-1][(j*10-goods[i].v-goods[goods[i].a2].v-goods[goods[i].a1].v)/10]+temp3);
                    }
                }
            }
        }
        return dp[len][N];
    }

//    public static int maxValueShop(int[][] list,int N){
//        int len = list.length;
//        //将附件转换为主件
//        //将每个物品的价格与重要度相乘作为价值v
//        int[] v = new int[list.length+1];
//        int[] w = new int[list.length+1];//物品的价格
//        //物品额外产生的价值ex_v
//        int[] ex_v = new int[list.length+1];
//        int[] ex_w = new int[list.length+1]; //额外花的钱
//        //初始化v和w
//        for (int i = 1; i < list.length+1; i++) {
//            v[i] = list[i-1][0] * list[i-1][1];
//            w[i] = list[i-1][0];
//        }
//        //计算购买某个物品时，额外花的钱和额外产生的价值
//        for (int i = 1; i < list.length; i++) {
//            if (list[i-1][2] > 0){
//                ex_v[i] = v[list[i-1][2]];
//                ex_w[i] = w[list[i-1][2]];
//                v[i] += ex_v[i];
//                w[i] += ex_w[i];
//            }
//        }
//        //接下来就是0-1背包问题，求最大价值
//        //dp[i][j]表示当前手中有钱j时（背包容量为j时），前i件物品所能获得的最大价值
//        int[][] dp = new int[len+1][N/10+1];
//        for (int i = 1; i < len + 1; i++) {
//            for (int j = 1; j < N/10 + 1; j++) {
//                if (j < w[i]){
//                    dp[i][j] = dp[i-1][j];
//                }else {
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
//                }
//            }
//        }
//        return dp[len][N/10];
//    }
}

class Goods{
    public int v;//价格
    public int p;//重要度
    public int q;//主附件

    public int a1 = 0; //附件1
    public int a2 = 0; //附件2

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