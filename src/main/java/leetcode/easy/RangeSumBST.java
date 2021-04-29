package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author wangxiang
 * @since 2021/4/27 17:01
 */
public class RangeSumBST {
    //方法1：遍历树获取所有节点，再遍历汇总所有符合条件的值
    public static int rangeSumBST1(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        BST(root, list);
        int sum = 0;
        for (Integer i : list) {
            if (low <= i && i <= high) {
                sum += i;
            }
        }
        return sum;
    }

    public static void BST(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        BST(root.left, list);
        list.add(root.val);
        BST(root.right, list);
    }


    //方法2：遍历树获取所有节点,只有符合条件时才算入综合
    public static int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        sum += rangeSumBST2(root.left, low, high);
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        sum += rangeSumBST2(root.right, low, high);
        return sum;
    }


    //解法3：通过二叉查找树特点，减少要扫描的节点
    //当前节点在 [low, high]内，则sum = this.val + left() + right();
    //当前节点在 (-∞,low)内，则sum = right();
    //当前节点在 (high,-∞)内，则sum = left();
    public static int rangeSumBST3(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (low <= root.val && root.val <= high) {
            sum += root.val;
            sum += rangeSumBST3(root.left, low, high);
            sum += rangeSumBST3(root.right, low, high);
        } else if (root.val < low) {
            sum += rangeSumBST3(root.right, low, high);
        } else {
            sum += rangeSumBST3(root.left, low, high);
        }

        return sum;
    }

    //针对方法3优化
    public static int rangeSumBST4(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (low <= root.val && root.val <= high) {
            return root.val + rangeSumBST4(root.left, low, high) + rangeSumBST4(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST4(root.right, low, high);
        } else {
            return rangeSumBST4(root.left, low, high);
        }
    }

    //方法5：广度优先遍历
    public static int rangeSumBST5(TreeNode root, int low, int high) {
        int sum = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null){
                continue;
            }
            if (low <= node.val && node.val <= high) {
                sum += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.val < low) {
                queue.offer(node.right);
            } else {
                queue.offer(node.left);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode head = TreeNode.initTreeNode();
        System.out.println(rangeSumBST5(head, 2, 2));
    }
}
