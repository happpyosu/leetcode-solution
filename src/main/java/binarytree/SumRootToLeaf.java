package binarytree;

import datastruct.TreeNode;

//todo
// leetcode 1022
public class SumRootToLeaf {

    private int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        recur(root, new StringBuilder());
        return sum;
    }

    private void recur(TreeNode node, StringBuilder sb){
        if(node == null) return;

        sb.append(node.val);

        if(node.left == null && node.right == null) {
            sum += (Integer.valueOf(sb.toString(), 2)) % (Math.pow(10, 9) + 7);
        }

        if(node.left != null) recur(node.left, sb);
        if(node.right != null) recur(node.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }

}
