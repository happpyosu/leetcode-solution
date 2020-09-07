package oneproblemeveryday;

import datastruct.TreeNode;

// leetcode1325
public class RemoveLeafNodes {

    public static void main(String[] args) {
        RemoveLeafNodes r = new RemoveLeafNodes();
        TreeNode root = new TreeNode(1);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);

        root.left = n1; root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;

        TreeNode a = r.removeLeafNodes(root, 2);
        r.recur(a);

    }

    public void recur(TreeNode root){
        if(root == null) return;
        recur(root.left);
        System.out.println(root.val);
        recur(root.right);
    }


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        recur(root, target);

        if(root.val == target && root.left == null && root.right == null){
            return null;
        }

        return root;
    }

    private void recur(TreeNode node, int target){
        if(node == null) return;

        recur(node.left, target);
        recur(node.right, target);

        TreeNode l = node.left;
        if(l != null && l.left == null && l.right == null && l.val == target){
            node.left = null;
        }

        TreeNode r = node.right;
        if(r != null && r.left == null && r.right == null && r.val == target){
            node.right = null;
        }

    }

}
