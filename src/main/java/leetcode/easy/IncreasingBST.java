package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 897. 递增顺序搜索树
 *
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 *
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncreasingBST {


    public static void BST(TreeNode root) {
        if (root == null) {
            return;
        }
        BST(root.left);
        System.out.println(root.val);
        BST(root.right);
    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        TreeNode head = new TreeNode(0);
        TreeNode tmp = head;
        for (Integer integer : result) {
            TreeNode node = new TreeNode(integer);
            tmp.right = node;
            tmp = tmp.right;
        }
        return head.right;
    }

    public static void traverse(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        traverse(treeNode.left, result);
        result.add(treeNode.val);
        traverse(treeNode.right, result);
    }


    public static void main(String[] args) {
        TreeNode treeNode5 = TreeNode.initTreeNode();

        //BST(treeNode5);
        TreeNode treeNode = increasingBST(treeNode5);
        System.out.println(treeNode);
    }


}

