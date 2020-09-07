package binarytree;

import datastruct.TreeNode;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return recur(root, sum);
    }

    private boolean recur(TreeNode node, int remain){
        if(node == null) return false;

        if(node.left == null && node.right == null){
            return remain == node.val;
        }else {
            return recur(node.left, remain - node.val) || recur(node.right, remain - node.val);
        }
    }
}
