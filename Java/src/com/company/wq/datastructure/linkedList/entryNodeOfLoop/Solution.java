package com.company.wq.datastructure.linkedList.entryNodeOfLoop;

import java.util.HashSet;
import java.util.Set;

/**
 * [BM7 链表中环的入口结点](https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj)
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 判断是否有环，有环就返回相遇的节点，无环就返回null
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {
        //先判断为空时
        if (head == null){
            return null;
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
                return slow;
            }
        }
        //如果不存在环，就会跳出循环，直接返回false
        return null;
    }

    /**
     * 先判断是否有环，无环就返回空，有环就先返回相遇的位置节点，然后让快指针指向头节点，然后遍历链表
     * 快慢指针都走一步，相遇的位置即是环的入口（理由：见优秀解答
     * https://blog.nowcoder.net/n/f80b6497aaa944ae9aadfb7307467d4e?f=comment）
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle(pHead);
        if (slow == null){
            return null;
        }
        ListNode fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 利用Set集合的不能存储重复元素的特性，如果不能存储即说明有环，能存储则无环
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        while (pHead != null){
            //如果不能加入到set中，说明有环，环的入口即是当前遍历的节点
            if (!set.add(pHead)){
                return pHead;
            }
            //能加入到set中，说明无环，继续遍历
            pHead = pHead.next;
        }
        //如果能走出循环，只能pHead一开始就为空或者无环
        return null;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
