package com.company.wq.datastructure.linkedList.rangeReverse;

public class Solution {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

//        ListNode n1 = new ListNode(1);
//        n1.next = null;

//        ListNode n2 = new ListNode(2);
//        ListNode n1 = new ListNode(1);
//        n1.next = n2;
//        n2.next = null;
        ListNode head = reverseKGroup(n1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     *解法一：递归思想
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        //找到每次翻转的尾部
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //如果不到k个节点，直接返回头节点，不反转
            if (tail == null){
                return head;
            }
            tail = tail.next;
        }
        //进行反转，反转时需要的前序和当前节点
        ListNode pre = null;
        ListNode curr = head;
        //在达到当前段尾节点前
        while (curr != null){
            //反转
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        //因为tail是从head开始向后遍历到第k个节点，再反转，之后head便成了前k个节点的尾节点
        //当前尾指向下一段要反转的链表
        head.next = reverseKGroup(tail,k);
        return pre;
    }

    /**
     * 解法二：利用之前做的题目，反转局部链表，将链表拆成k个一组
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here

        //计数链表的长度count
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count <= 1) {
            return head;
        }
        //方法返回前k个节点反转后的表头newHead，所以单独拿出来
        ListNode newHead;
        if (k <= count) {
            newHead = reverseBetween(head, 1, k);
        } else {
            k = k % count;
            newHead = reverseBetween(head, 1, k);
        }

        //k+1到最后，每k个进行反转
        int i = k + 1;
        for (; i < count && (i + k - 1) < count; i += k) {
            reverseBetween(newHead, i, i + k - 1);
        }

        return newHead;
    }

    /**
     * 利用之前做的题目，反转链表
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        //用一个虚拟的头节点加在head之前
        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;
        //截取m到n之间的链表，leftNode-rightNode
        //第一步：先找到m-1位置的节点，也就是m前面的一个节点
        ListNode preLeft = virtualHead;
        int i = 0;
        for (; i < m - 1; i++) {
            preLeft = preLeft.next;
        }
        ListNode leftNode = preLeft.next;


        ListNode rightNode = preLeft;
        //找到n位置的节点rightNode，以及n+1位置的节点postRightNode
        for (; i < n; i++) {
            rightNode = rightNode.next;
        }
        ListNode postRightNode = rightNode.next;

        //断开preLeft与leftNode之间的链接
        preLeft.next = null;
        //断开rightNode与postRightNode之间的链接
        rightNode.next = null;
        //断开链接之后就形成了一个新的子链表，从leftNode到rightNode

        //第二步：局部链表反转
        reverseList(leftNode);
        //第三步：重新将链表接起来
        preLeft.next = rightNode;
        leftNode.next = postRightNode;

        return virtualHead.next;
    }

    public static void reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tempNode;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}