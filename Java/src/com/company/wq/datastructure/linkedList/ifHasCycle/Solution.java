package com.company.wq.datastructure.linkedList.ifHasCycle;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        //先判断为空时
        if (head == null){
            return false;
        }
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //fast走两步，slow走一步
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //如果存在环一定会相遇
            if (fast == slow){
                return true;
            }
        }
        //如果不存在环，就会跳出循环，直接返回false
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
