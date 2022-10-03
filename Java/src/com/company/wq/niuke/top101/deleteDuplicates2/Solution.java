package com.company.wq.niuke.top101.deleteDuplicates2;

/*
BM16 删除有序链表中重复的元素-II
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        //定义一个虚拟头指针
        ListNode virturalHead = new ListNode(-1);
        virturalHead.next = head;
        //用来遍历相等元素的指针
        ListNode cur = virturalHead;
        //无重复元素的链表
        ListNode node = cur;
        while (cur.next != null && cur.next.next != null){
            //cur指针的后面连续两个元素相等
            if (cur.next.val == cur.next.next.val){
                //将相等的元素值保存到临时变量中
                int temp = cur.next.val;
                //遍历相等元素，cur.next的值与temp相等的话，就将cur指向cur.next的下一个节点
                while (cur.next != null && cur.next.val == temp){
                    cur.next = cur.next.next;
                }
            }else {
                //cur指针后面的两个连续元素不相等，则往后移
                cur = cur.next;
            }
        }
        return virturalHead.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}