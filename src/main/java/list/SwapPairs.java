package list;

import datastruct.ListNode;

public class SwapPairs {

    public static void main(String[] args) {
        SwapPairs s = new SwapPairs();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode node = s.swapPairs(l1);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode swapPairs(ListNode head) {
        return recur(head);
    }

    private ListNode recur(ListNode node){
        if(node == null) return null;

        ListNode i = node;
        ListNode j = node.next;

        if(j == null) return i;
        ListNode temp = j.next;
        j.next = i;
        i.next = recur(temp);

        return j;
    }
}
