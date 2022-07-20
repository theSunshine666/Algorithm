package com.company.wq.datastructure.linkedList.mergeKsortedLists;

import java.util.ArrayList;

/**
 * [BM5 合并k个已排序的链表](https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj)
 */
public class Solution {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideMerge(lists,0,lists.size()-1);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
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
        cur.next = ( list1 == null) ? list2 : list1;

        return res.next;
    }

    public static ListNode divideMerge(ArrayList<ListNode> lists,int left,int right){
        if (left > right){
            return null;
        }else if (left == right){
            return lists.get(left);
        }
        int mid = (left + right) / 2;
        return Merge(divideMerge(lists,left,mid),divideMerge(lists,mid+1,right));
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
