package binarytree;

import datastruct.TreeNode;

public class SumOfLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        recur(root.left, true);
        recur(root.right, false);
        return sum;
    }

    private void recur(TreeNode node, boolean isLeft){
        if(node == null) return;
        if(node.left == null && node.right == null && isLeft) sum += node.val;
        if(node.left != null) recur(node.left, true);
        if(node.right != null) recur(node.right, false);

    }

}
