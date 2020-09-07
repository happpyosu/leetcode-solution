package binarytree;

import datastruct.TreeNode;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return recur(root);
    }

    private TreeNode pre;
    private boolean recur(TreeNode node){
        if(node == null) return true;

        if(recur(node.left)){
            if(pre != null && pre.val > node.val) return false;
            pre = node;
            return recur(node.right);
        }
        return false;
    }
}
