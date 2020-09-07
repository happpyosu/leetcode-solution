package binarytree;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodecBinaryTree {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        CodecBinaryTree c = new CodecBinaryTree();
        String serialize = c.serialize(n1);
        System.out.println(serialize);
        TreeNode root = c.deserialize(serialize);

        String serialize1 = c.serialize(root);
        System.out.println(serialize1);
    }


    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recur_encode(root, sb);
        return sb.toString();
    }

    private void recur_encode(TreeNode node, StringBuilder sb){
        if(node == null) sb.append(",null");
        else {
            sb.append(",").append(node.val);
            recur_encode(node.left, sb);
            recur_encode(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        list.remove(0);
        return recur_decode(list);
    }

    private TreeNode recur_decode(List<String> list){
        if(list.size() == 0) return null;

        String s = list.remove(0);

        if(s.equals("null")) return null;

        int val = Integer.parseInt(s);
        TreeNode node = new TreeNode(val);

        node.left = recur_decode(list);
        node.right = recur_decode(list);

        return node;
    }

}
