package binarytree;

import datastruct.TreeNode;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        recur(root, p);
        return a;
    }

    private boolean find = false;
    private TreeNode a = null;
    private void recur(TreeNode node, TreeNode p){
        if(node == null) return;
        recur(node.left, p);
        if(find) {
            a = node;
            find = false;
        }
        if(node == p) find = true;

        recur(node.right, p);
    }

}
