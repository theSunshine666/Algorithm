package com.company.wq.datastructure.linkedList.removeNthFromEnd;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 解法一：先统计链表长度，然后找到倒数第n个节点的前一个节点，然后断开倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        //先统计链表的长度len
        int len = 0;
        ListNode node = head;
        while (node != null){
            len++;
            node = node.next;
        }
        //如果len和n相等，直接返回头节点的下一个节点
        if (len == n){
            return head.next;
        }
        //遍历不能直接用head，定义一个临时节点
        ListNode temp = head;
        //从头走到len-n-1，也就是要删除的节点的前一个节点
        for (int i = 0; i < len - n - 1; i++) {
            temp = temp.next;
        }
        //删除倒数第n个节点
        temp.next = temp.next.next;

        return head;
    }

    /**
     * 解法二：双指针解法（快慢指针）
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2 (ListNode head, int n) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //先让快指针往前移动n
        for (int i = 0; i < n; i++) {
            if (fast != null){
                fast = fast.next;
            }else {
                //如果fast为空了，说明不够n个节点，返回空
                return null;
            }
        }
        if (fast == null){
            return head.next;
        }
        //让fast和slow同步往前移动
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //fast为空，此时慢指针指向的就是倒数第n+1个节点，也就是倒数第n个节点前面的节点
        slow.next = slow.next.next;
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