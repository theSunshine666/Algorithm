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
        // 快指针移动了n位后指向了空，说明n等于当前链表的长度，需要将表头删除，
        // 因此返回 head.next
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
    
    /**
     * 解法三、借用了表头，优化了解法二中fast往前移动n位时需要判断为空的情况
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3 (ListNode head, int n) {
        //添加表头
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        ListNode fast = head;
        //快指针先往前移动n位
        while (n!=0){
            fast = fast.next;
            n--;
        }
        //快指针和当前指针同步移动,当fast移动到最后为null时，则当前指针cur移动到倒数第n个节点
        while (fast != null){
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }
        //删除该位置的节点
        pre.next = cur.next;
        //返回去掉表头
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
