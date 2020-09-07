package commonskill;

import datastruct.ListNode;

public class MergeTwoSortedList {

    // 递归的合并两个已经排序的链表
    public ListNode mergeTwoSortedList(ListNode h1, ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;

        if(h1.val < h2.val){
            h1.next = mergeTwoSortedList(h1.next, h2);
            return h1;
        }else {
            h2.next = mergeTwoSortedList(h1, h2.next);
            return h2;
        }
    }

}
