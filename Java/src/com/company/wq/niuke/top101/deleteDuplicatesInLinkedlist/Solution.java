package com.company.wq.niuke.top101.deleteDuplicatesInLinkedlist;

/*
BM15 删除有序链表中重复的元素-I
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
        //用来遍历的指针
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                //当前元素与下一个元素相同，就将当前指针指向下一个节点的下一个节点，即删除下一个节点，达到去重的目的
                cur.next = cur.next.next;
            }else {
                //不相同则当前指针往后移动
                cur = cur.next;
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}