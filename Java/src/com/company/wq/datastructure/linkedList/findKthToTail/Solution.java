package com.company.wq.datastructure.linkedList.findKthToTail;


import java.util.Stack;

/**
 * [BM8 链表中倒数最后k个结点](https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj)
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 解法一：双指针（快慢指针）
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        //定义快慢指针
        ListNode fast = pHead;
        ListNode slow = pHead;
        //快指针先走k步
        for (int i = 0; i < k; i++) {
            if (fast != null){
                fast = fast.next;
            }else {
                //走步到k步fast就为空了，说明链表不到k步，返回空
                return null;
            }
        }
        //快慢指针同步走，走到最后fast==null，则slow指向倒数第k个节点
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 解法二：先统计链表节点个数，再从头遍历n-k个即为最后k个节点
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail2 (ListNode pHead, int k) {
        //先统计链表节点个数
        int count = 0;
        ListNode node = pHead;
        while (node != null){
            count++;
            node=node.next;
        }
        if (count < k){
            return null;
        }
        //从头往后遍历count-k个
        for (int i = 0; i < count - k; i++) {
            pHead = pHead.next;
        }
        return pHead;
    }

    /**
     * 方法三：利用栈的后入先出的特点，先将全部节点入栈，再出栈k个
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail3 (ListNode pHead, int k) {
        if (pHead == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = pHead;
        //先将所有节点全部入栈
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        //获取栈顶元素
        ListNode newHead = null;
        //出栈k个，插入到栈顶元素之前
        for (; k != 0 && !stack.isEmpty(); ) {
            ListNode temp = stack.pop();
            temp.next = newHead;
            newHead = temp;
            k--;
        }
        //栈为空，i<k，说明k是大于链表长度的
        if (stack.isEmpty() && k != 0){
            return null;
        }
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
