package leetcode.easy;

/**
 * Created by Mr.Wang on 2019/6/17.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode initTreeNode() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;

        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;

        treeNode2.left = treeNode1;

        treeNode6.right = treeNode8;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        return treeNode5;
    }

    public static TreeNode initTreeNode2() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;

        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;

        treeNode2.left = treeNode1;

        treeNode6.right = treeNode8;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        return treeNode5;
    }
}