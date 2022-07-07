package com.company.wq.niuke.huawei.reverseList;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            ListNode n = new ListNode(scanner.nextInt());
//        }

        ListNode head = Main.reverseList3(n1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 解法一：
     * 该解法首先判断了head为空和只有一个节点的情况，可以直接返回，只有节点数大于1的情况才执行下面的步骤
     * 首先定义pre=head，pre是head前面的节点
     * 然后head=head.next往后移动
     * prePre是pre前面的节点，一开始定义为空null
     * next是head后面的节点
     * 遍历链表，首先断开head跟next的指针，让head指向它前面的节点pre，pre指向它前面的节点prePre，
     * pre前面的往后移动到pre，pre往后移动到head，head往后移动到next，next往后移动到head.next，
     * 直到next为空，停止循环，这时head与pre之间是断开的，跳出循环后要连接上，并返回head
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        head = head.next;
        ListNode next = head.next;
        ListNode prePre = null;
        while (next != null){
            head.next = pre;
            pre.next = prePre;
            prePre = pre;
            pre = head;
            head = next;
            next = head.next;
        }
        head.next = pre;
        return head;
    }

    /**
     * 解法二；
     * 这种方法避免了解法一中head为空和只有一个节点的判断情况，且更省空间
     * 定义newHead为空null
     * 定义临时节点指向head的下一个节点
     * head.next指向newHead，
     * newHead往后移，head往后移
     * 直到head为空，此时newHead指向原链表的尾节点，返回newHead
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        ListNode newHead = null;
        while (head != null){
            ListNode tempNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tempNode;
        }
        return newHead;
    }

    /**
     * 解法三：用栈解决
     * 先将所有节点入栈，弹出栈顶的节点作为新链表的头节点，然后逐个出栈并连接至新的链表上，
     * 最后一定要让原链表的头节点指向空，不然会死循环
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        //先将所有节点入栈
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()){
            return null;
        }
        //先弹出栈顶，即为新链表的头节点
        ListNode tempNode = stack.pop();
        //将头节点保存下来
        ListNode newHead = tempNode;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        //最后一定要让原链表的头节点指向空，不然就死循环了
        tempNode.next = null;
        return newHead;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
    ListNode(){}


    public void initListNode(){
        ListNode head = new ListNode();
    }
}
