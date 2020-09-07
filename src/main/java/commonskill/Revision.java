package commonskill;

import datastruct.ListNode;

public class Revision {

    private static class MergeSortLinkedList{

        // 裁剪链表返回下一个链表的开头
        private ListNode cut(ListNode head, int size){
            ListNode tail = head;
            while (tail != null && --size > 0) tail = tail.next;

            if(tail == null) return null;
            ListNode temp = tail.next;
            tail.next = null;
            return temp;
        }

        private ListNode merge(ListNode h1, ListNode h2){
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (h1 != null && h2 != null){
                if(h1.val < h2.val) {
                    p.next = h1;
                    p = p.next;
                    h1 = h1.next;
                }else {
                    p.next = h2;
                    p = p.next;
                    h2 = h2.next;
                }
            }

            if(h1 == null) p.next = h2;
            else p.next = h1;

            ListNode dummyNext = dummy.next;
            dummy.next = null;
            return dummyNext;
        }

        public ListNode mergeSortLinkedList(ListNode head){
            int len = 0;
            ListNode h = head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            while (h != null){
                len++;
                h = h.next;
            }

            for(int sz=1; sz < len; sz <<= 1){
                ListNode cur = dummy.next;
                ListNode tail = dummy;

                while (cur != null){
                    ListNode left = cur;
                    ListNode right = cut(left, sz);

                    tail.next = merge(left, right);

                    while (tail.next != null){
                        tail = tail.next;
                    }

                    cur = cut(right, sz);
                }

            }
            return dummy.next;
        }



    }


}
