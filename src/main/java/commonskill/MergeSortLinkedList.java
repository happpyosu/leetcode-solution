package commonskill;

import datastruct.ListNode;

//归并排序一个链表
public class MergeSortLinkedList{

    public static ListNode cut(ListNode head, int size){
        ListNode tail = head;
        while (--size > 0 && tail != null) tail = tail.next;

        if(tail == null) return tail;
        ListNode temp = tail.next;
        tail.next = null;
        return temp;
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        p.next = (l1 == null) ? l2 : l1;
        return dummyHead.next;

    }
}
