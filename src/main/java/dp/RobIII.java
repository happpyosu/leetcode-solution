package dp;

import datastruct.TreeNode;

public class RobIII {

    public static void main(String[] args) {
    }


    public int rob(TreeNode root) {
        if(root == null) return 0;

        int sum1 = rob(root.left) + rob(root.right);

        int sum2 = root.val;
        if(root.left != null){
            sum2 += (rob(root.left.left) + rob(root.left.right));
        }

        if(root.right != null){
            sum2 += (rob(root.right.left) + rob(root.right.right));
        }

        return Math.max(sum1, sum2);
    }

}
