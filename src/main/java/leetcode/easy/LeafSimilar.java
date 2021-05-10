package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangxiang
 * @since 2021/5/10 11:11
 */
public class LeafSimilar {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        putNodeLeafValue(root1,list1);
        putNodeLeafValue(root2,list2);

        return list1.equals(list2);
    }

    private static void putNodeLeafValue(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            list.add(node.val);
        }
        if(node.left != null){
            putNodeLeafValue(node.left, list);
        }
        if(node.right != null){
            putNodeLeafValue(node.right, list);
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.initTreeNode();
        TreeNode root2 = TreeNode.initTreeNode();
        System.out.println(leafSimilar(root1,root2));
    }
}
