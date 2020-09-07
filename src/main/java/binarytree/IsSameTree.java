package binarytree;

import datastruct.TreeNode;

public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recur(p, q);
    }

    private boolean recur(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;

        if(node1.val == node2.val){
            return recur(node1.left, node2.left) && recur(node1.right, node2.right);
        }else {
            return false;
        }
    }

}
