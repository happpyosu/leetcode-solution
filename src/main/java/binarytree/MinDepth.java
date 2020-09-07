package binarytree;

import datastruct.TreeNode;

// 111. 二叉树的最小深度
public class MinDepth {

    public static void main(String[] args) {
        MinDepth m = new MinDepth();
        int depth = m.minDepth(TreeNode.testTree);
        System.out.println(depth);

    }

    public int minDepth(TreeNode root) {
        return recur(root);
    }

    private int recur(TreeNode node){
        if(node == null) return 0;
        return Math.min(recur(node.left), recur(node.right)) + 1;
    }



}
