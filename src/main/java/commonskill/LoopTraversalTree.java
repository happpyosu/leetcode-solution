package commonskill;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树前序非递归遍历
// todo
public class LoopTraversalTree {

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);

        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;

        List<Integer> list1 = preOrder(n0);
        List<Integer> list2 = inOrder(n0);
        List<Integer> list3 = postOrder(n0);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }


    public static List<Integer> preOrder(TreeNode root){
        List<Integer> ret = new ArrayList<>();

        if(root == null) return ret;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ret.add(cur.val);

            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }

        return ret;

    }

    public static List<Integer> inOrder(TreeNode root){
        List<Integer> ret = new ArrayList<>();

        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            ret.add(p.val);
            p = p.right;
        }

        return ret;

    }

    public static List<Integer> postOrder(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        TreeNode p;

        while (!stack1.isEmpty()){
            p = stack1.pop();
            stack2.push(p);

            if(p.left != null) stack1.push(p.left);
            if(p.right != null) stack1.push(p.right);

        }

        while (!stack2.isEmpty()) ret.add(stack2.pop().val);
        return ret;
    }




}
