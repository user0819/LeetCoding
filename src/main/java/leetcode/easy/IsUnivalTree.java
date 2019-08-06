package leetcode.easy;

import java.util.LinkedList;

/**
 * Created by Mr.Wang on 2019/6/27.
 */
public class IsUnivalTree {
    public static boolean isUnivalTree(TreeNode root) {
        boolean isUnivalTree =true;
        LinkedList queue = new LinkedList<TreeNode>();
        queue.push(root);
        int val = root.val;
        TreeNode next;
        while(!queue.isEmpty()){
            next = (TreeNode)queue.pop();
            if(next.val != val){
                isUnivalTree = false;
                break;
            }

            if(next.left!=null){
                queue.push(next.left);
            }
            if (next.right != null){
                queue.push(next.right);
            }
        }
        return isUnivalTree;
    }
}


