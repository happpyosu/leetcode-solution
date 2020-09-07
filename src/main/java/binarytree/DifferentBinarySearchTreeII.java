package binarytree;

import datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class DifferentBinarySearchTreeII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }

    //递归的语义是，生成从start到end的所有二叉搜索树的列表
    private List<TreeNode> generate_trees(int start, int end){
        List<TreeNode> all_trees = new LinkedList<>();

        if(start > end){
            all_trees.add(null);
            return all_trees;
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> leftTrees = generate_trees(start, i - 1);
            List<TreeNode> rightTrees = generate_trees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    all_trees.add(root);
                }
            }
        }
        return all_trees;
    }


}
