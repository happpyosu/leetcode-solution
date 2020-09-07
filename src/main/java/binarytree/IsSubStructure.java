package binarytree;

import datastruct.TreeNode;

public class IsSubStructure {


    public boolean isSubStructure(TreeNode a, TreeNode b){
        if(a == null) return false;
        if(b == null) return false;

        return isSub(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }


    private boolean isSub(TreeNode A, TreeNode B){

        if(B == null) return true;
        if(A == null) return false;

        boolean cur = false;
        if(A.val == B.val){
            cur = isSub(A.left, B.left) && isSub(A.right, B.right);
        }else return false;

        return cur;
    }



}
