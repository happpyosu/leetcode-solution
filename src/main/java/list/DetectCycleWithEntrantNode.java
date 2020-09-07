package list;

import datastruct.ListNode;

public class DetectCycleWithEntrantNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(-4);

        head.next = l1; l1.next = l2; l2.next = l3; l3.next = l1;


        DetectCycleWithEntrantNode d = new DetectCycleWithEntrantNode();
        ListNode node = d.detectCycle(head);
        System.out.println(node.val);
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode i = head; ListNode j = head.next;
        while (i != j){
            if(i == null || j == null) return null;
            i = i.next;

            j = j.next;
            j = (j == null) ? null : j.next;
        }

        ListNode k = i.next; int count = 1;
        while (k != i) {
            k = k.next;
            count++;
        }

        i = j = head;

        while (count > 0) {
            j = j.next;
            count--;
        }

        while (i != j){
            i = i.next;
            j = j.next;
        }

        return i;
    }

}
