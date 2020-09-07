package datastruct;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode testTree ;
    static {

        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);

        root.left = l1; root.right = r1;

        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        r1.left = l2;
        r1.right = r2;

        testTree = root;
    }


}
