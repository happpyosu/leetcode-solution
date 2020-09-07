package binarytree;

import datastruct.TreeNode;

// todo
// 617
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return recur(t1, t2);
    }

    private TreeNode recur(TreeNode node1, TreeNode node2){

        if(node1 != null && node2 != null){
            node1.val += node2.val;
            node1.left = recur(node1.left, node2.left);
            node1.right = recur(node2.right, node2.right);

            return node1;
        }else if(node1 == null && node2 != null){
            return node2;
        }else if(node1 != null){
            return node1;
        }else {
            return null;
        }

    }

}
