package oneproblemeveryday;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// leetcode 1028
public class RecoverFromPreorder {

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);

        n0.left = n1; n0.right = n2; n1.left = n3; n1.right = n4; n2.left = n5; n2.right = n6;

        RecoverFromPreorder r = new RecoverFromPreorder();
        TreeNode root = r.recoverFromPreorder("1-2--3---4-5--6---7");
        r.dfsTree(root);


    }


    public TreeNode recoverFromPreorder(String S) {

        List<int[]> list = new LinkedList<>();

        int start = 0;
        while (start < S.length()){
            int layers = 0;
            for(int i=start; i<S.length(); i++){
                if(S.charAt(i) == '-') layers++;
                else if(Character.isDigit(S.charAt(i))){
                    StringBuilder sb = new StringBuilder();
                    int j = i;
                    while (j < S.length() && Character.isDigit(S.charAt(j))) sb.append(S.charAt(j++));
                    list.add(new int[]{Integer.parseInt(sb.toString()), layers});
                    start = j;
                    break;
                }
            }
        }

        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }

        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<int[]> list, int l, int r){
        if(l > r) return null;

        TreeNode root = new TreeNode(list.get(l)[0]);
        int leftDepth = list.get(l)[1] + 1;
        int mid = r;

        for(int i=r; i >= l+2; i--){
            if(list.get(i)[1] == leftDepth){
                mid = i - 1;
                break;
            }
        }

        root.left = build(list, l+1, mid);
        root.right = build(list, mid+1, r);
        return root;
    }




    private void dfsTree(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        dfsTree(root.left);
        dfsTree(root.right);
    }

}
