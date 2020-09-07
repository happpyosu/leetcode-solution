package binarytree;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

import datastruct.TreeNode;

import java.util.HashMap;

// 前序遍历的特点 [根节点 | 左子树 | 右子树]
// 中序遍历  [左子树| 根节点 | 右子树]
public class RebuildBinaryTree {

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] pre;

    public TreeNode rebuildTree(int[] preOrder, int[] midOrder){
        this.pre = preOrder;

        for(int i=0; i<midOrder.length; i++){
            map.put(midOrder[i], i);
        }

        return recur(0, 0, pre.length - 1);

    }

    private TreeNode recur(int preIndex, int inLeft, int inRight){
        if(inLeft > inRight){ return null; }

        int val = pre[preIndex];
        TreeNode node = new TreeNode(val);
        int midIndex = map.get(val);

        node.left = recur(preIndex + 1, inLeft, midIndex - 1);
        node.right = recur(preIndex + midIndex - inLeft + 1, midIndex + 1, inRight);

        return node;
    }




}
