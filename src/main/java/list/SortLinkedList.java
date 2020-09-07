package list;

import datastruct.ListNode;

public class SortLinkedList {

    public static void main(String[] args) {
        SortLinkedList s = new SortLinkedList();

        ListNode head = new ListNode(4);
        head.build(3).build(2).build(1);

        ListNode h = s.mergeSortList(head);
        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }

    }

    public ListNode mergeSortList(ListNode head){
        int len = 0;
        ListNode h = head;
        while (h != null){
            len++;
            h = h.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for(int i=1; i<len; i <<= 1){
            ListNode cur = dummy.next;
            ListNode tail = dummy;

            while (cur != null){
                ListNode left = cur;
                ListNode right = cut(left, i);
                cur = cut(right, i);
                tail.next = merge(left, right);


                while (tail.next != null){
                    tail = tail.next;
                }

            }
        }

        return dummy.next;

    }


    private ListNode merge(ListNode l1, ListNode l2){
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




    //从链表头开始裁剪一定范围的链表段，并返回该链表段的下一个节点
    private ListNode cut(ListNode head, int size){
        ListNode tail = head;
        while (--size > 0 && tail != null){
            tail = tail.next;
        }

        if(tail == null) return null;

        ListNode temp = tail.next;
        tail.next = null;
        return temp;
    }

}
