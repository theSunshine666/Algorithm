package com.company.wq.datastructure.linkedList.mergeSortedLinkedList;


/**
 * [BM4 合并两个排序的链表](https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj)
 *
 */
public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-10);
        ListNode n3 = new ListNode(-9);
        ListNode n4 = new ListNode(-4);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(6);

        ListNode n8 = new ListNode(-8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;

        n8.next = null;

        ListNode head = Merge(n1,n8);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    /**
     * 解法一：递归
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }
        if (list1.val > list2.val){
            list2.next = Merge2(list1,list2.next);
            return list2;
        }else {
            list1.next = Merge2(list1.next,list2);
            return list1;
        }
    }

    /**
     * 解法二：借用一个临时的节点
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        //新建一个链表，存储结果返回值
        ListNode res = new ListNode(0);
        //新建一个节点，用来连接较小的节点
        ListNode cur = res;
        //两个链表都不为空时
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        //cur指向不为空的那个链表剩余的节点
        cur.next = ( list1 == null) ? list2 : list1;
        //返回新建的头节点的next才为最终合并好的链表
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}