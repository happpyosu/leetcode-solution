package binarytree;

import datastruct.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }

    private TreeNode recur(TreeNode root, TreeNode p, TreeNode q){

        if(root == null || root == p || root == q) return root;

        TreeNode left = recur(root.left, p, q);
        TreeNode right = recur(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }

}
