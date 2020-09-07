package list;

import datastruct.ListNode;

// leetcode

// todo
// todo1
public class MergeKLists {

    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;

        if(h1.val < h2.val){
            h1.next = merge(h1.next, h2);
            return h1;
        }else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }


    public ListNode merge2(ListNode h1, ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;

        if(h1.val < h2.val){
            h1.next = merge2(h1.next, h2);
            return h1;
        }else {
            h2.next = merge2(h1, h2.next);
            return h2;
        }
    }


}
