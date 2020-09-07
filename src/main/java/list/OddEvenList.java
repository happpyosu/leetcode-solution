package list;

import datastruct.ListNode;

// leetcode 328
// 奇偶链表
public class OddEvenList {

    public static void main(String[] args) {
        OddEvenList o = new OddEvenList();
        ListNode head = new ListNode(1);
        head.build(2).build(3).build(4).build(5).build(6);

        ListNode h = o.oddEvenList(head);

        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }

    }


    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head; ListNode even = head.next; ListNode evenHead = even;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
