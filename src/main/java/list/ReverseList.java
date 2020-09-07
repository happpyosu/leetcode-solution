package list;

import datastruct.ListNode;

//todo
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        return  recur(head);

    }

    private ListNode recur(ListNode node){
        if(node == null || node.next == null) return node;

        ListNode p = recur(node.next);
        node.next.next = node;
        node.next = null;

        return p;
    }

}
