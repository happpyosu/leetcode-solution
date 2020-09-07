package list;

import datastruct.ListNode;

public class SplitListToParts {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.build(2).build(3).build(4).build(5).build(6).build(7);
        SplitListToParts s = new SplitListToParts();
        ListNode[] listNodes = s.splitListToParts(head, 3);

    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode h = root;
        int count = 0;
        while (h != null){
            count++;
            h = h.next;
        }

        int sz = count / k; int remain = count % k;

        ListNode[] list = new ListNode[k];
        h = root;
        for(int i=0; i<k; i++){
            int size = sz - 1;
            if(remain > 0){
                remain--;
                size += 1;
            }
            ListNode tail = h;
            while (size > 0 && tail != null){
                tail = tail.next;
                size--;
            }

            list[i] = h;

            ListNode temp;
            temp = (tail == null) ? null : tail.next;
            if(tail != null) tail.next = null;
            h = temp;
        }

        return list;
    }
}
