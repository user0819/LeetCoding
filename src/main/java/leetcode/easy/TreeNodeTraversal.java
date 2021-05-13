package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author XIANG
 * @since 2021/5/10 11:38
 */
public class TreeNodeTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.initTreeNode();
        List<Integer> list = new ArrayList<>();
        LDR2(treeNode, list);

        list.forEach(System.out::println);
    }

    // 递归方式

    //中序遍历LDR
    public static void LDR(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        LDR(treeNode.left, list);
        list.add(treeNode.val);
        LDR(treeNode.right, list);
    }

    //先序遍历VLR
    public static void VLR(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        VLR(treeNode.left, list);
        VLR(treeNode.right, list);
    }

    //后序遍历LRD
    public static void LRD(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        LRD(treeNode.left, list);
        LRD(treeNode.right, list);
        list.add(treeNode.val);
    }


    // 迭代方式


    // 先序遍历
    public static void VLR2(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    // 后序遍历
    public static void LRD2(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(0,treeNode.val);

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
    }

    // 中序遍历
    public static void LDR2(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || rootNode != null){
            while(rootNode != null){
                stack.push(rootNode);
                rootNode = rootNode.left;
            }

            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                rootNode = node.right;
            }
        }
    }
}
