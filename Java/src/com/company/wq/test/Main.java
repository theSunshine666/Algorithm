package com.company.wq.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public Main(){
        Node n6 = new Node(1);
        Node n5 = new Node(85,n6);
        Node n4 = new Node(50,n5);
        Node n3 = new Node(20,n4);
        Node n2 = new Node(10,n3);
        Node head = new Node(5,n2);
        n6.left = n5;
        n5.left = n4;
        n4.left = n3;
        n3.left = n2;
        n2.left = head;
        head.left = null;
    }

    public void buildLinkedList(Node head,int[] arr){
        Node temp = head;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            node.left = temp;
            temp.right = node;
            temp = node;
        }
    }

    public int[] solution(int[] arr){
        int[] result = null;
        int sum = 0;
        Node head = new Node(arr[0]);
        Node temp = head;
//        for (int i = 0; i < arr.length && arr[i] != (sum+=temp.value); i++) {
//            Node node = new Node(arr[i]);
//        }
        int i = 0;
        while(i < arr.length && arr[i++] != (sum+=temp.value)){
            Node node = new Node(arr[i]);
            node.left = temp;
            temp.right = node;
            temp = node;
        }

        return result;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        scanner.close();
        int[] nums = {5,10,20,50,85,1};
        Main main = new Main();



//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.println("sumLR("+j+","+(i-1)+")="+main.sumLR(nums,j,i-1));
//            }
//            System.out.println("sum("+i+")="+main.sum(nums,i));
//        }
        int[] result = main.stackNums(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 题目三：输入一个数组，从第一个数开始入栈，当将要入栈的数值与当前栈顶的前m个数值之和相等时，将这m个数值全部出栈，
     * 并将要入栈的数值*2再入栈，输出最后栈中剩余的数值。
     * 第一步：求出sum(R)和sum(L,R)
     * 第二步：遍历数组，如果将要插入栈中的数值与栈顶的前m个数之和不相等，则入栈
     *          否则，将m个数全部出栈，并将将要插入的数值*2进行入栈
     * 第三步：栈中的数值出栈并输出。
     * 题目二：
     * 给一个二维数组，用二进制表示，每一行表示一个十进制数，数组每一行可以进行左右平移，找出二维数组中最大的数（十进制）
     * 例如：
     * 1 0 0 1 1
     * 0 1 1 0 0
     * 0 0 1 0 1
     * 最大值为第一行代表的28，向右平移两位得到
     * @param nums
     * @return
     */
    public int[] stackNums(int[] nums){
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        boolean flag = false;
        int curr = 0;
        //遍历数组
        for (int i = 1; i < nums.length; i++) {
            //计算和
            for (int j = stack.size() - 1; j >= 0; j--) {

            }
            if (!flag){
                stack.push(nums[i]);
                flag = false;
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            while (!stack.isEmpty()){
                result[i] = stack.pop();
            }
        }
        return result;
    }

    public int sum(int[] arr,int r){
        if (r == 0){
            return arr[0];
        }
        return sum(arr,r-1)+arr[r];
    }

    public int sumLR(int[] arr,int l,int r){
        if (l == 0){
            return sum(arr,r);
        }
        return sum(arr,r) - sum(arr,l-1);
    }

    //从栈顶往下求和，直到与arr[i]相等
    public int sumStackM(Stack stack){
        int sum = 0;
        while (stack != null){

        }
        return sum;
    }
}

class Node{
    int value;
    Node left;
    Node right;
    public Node(){

    }
    public Node(int value){
        this.value = value;
    }
    public Node(Node left){
        this.left = left;
    }
    public Node(int value,Node right){
        this.value = value;
        this.right = right;
    }
    public Node(int value,Node left,Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}