package list;

import datastruct.ListNode;

public class IsPalindromeList {

    public boolean isPalindrome(ListNode head) {
        return true;
    }

    private ListNode recur(ListNode node){
        if(node == null || node.next == null) return node;

        ListNode p = recur(node.next);
        node.next.next = node;
        node.next = null;
        return p;

    }

}
