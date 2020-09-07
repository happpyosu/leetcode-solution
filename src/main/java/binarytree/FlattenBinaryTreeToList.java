package binarytree;

import datastruct.TreeNode;

// 左子树放到右子树
// 右边字数放到左子树最右的节点上
public class FlattenBinaryTreeToList {

    public void flatten(TreeNode root) {

        while (root != null){
            if(root.left == null){
                root = root.right;
            }else {
                TreeNode left = root.left;
                TreeNode right = root.right;

                root.right = left;
                while (left.right != null){
                    left = left.right;
                }
                left.right = right;
                root.left = null;
                root = root.right;

            }


        }

    }

}
