package binarytree;

import datastruct.TreeNode;

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return count;
    }

    private int count = 0;
    private void dfs(TreeNode node, int sum){
        if(node == null) return;
        count += recur(node, sum);
        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    private int recur(TreeNode node, int remain){
        if(node == null) return 0;

        int sum = 0;
        if(remain == node.val) sum += 1;

        int left = recur(node.left, remain - node.val);
        int right = recur(node.right, remain - node.val);

        return sum + left + right;
    }

}
