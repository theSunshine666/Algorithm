package com.company.wq.niuke.top101.oddEvenLinkedList;

/*
BM14 链表的奇偶重排
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null){
            return head;
        }

        //奇数节点
        ListNode odd = head;
        //偶数节点
        ListNode even = head.next;
        //给偶数节点一个头
        ListNode evenHead = even;

        while (even != null && even.next != null){
            //奇数位节点的下一个指向偶数位节点的下一个
            odd.next = even.next;
            //奇数位后移
            odd = odd.next;
            //偶数位节点的下一个指向奇数位节点的下一个
            even.next = odd.next;
            //偶数位后移
            even = even.next;
        }
        //将偶数的头节点接在奇数位节点的最后一个上
        odd.next = evenHead;
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
