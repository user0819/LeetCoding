package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wangxiang
 * @since 2021/5/17 19:25
 */
public class IsCousins {
    public static boolean isCousins(TreeNode root, int x, int y) {
       List<Integer> list = covert2List(root);
       int  xIndex=0, yIndex=0;
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i) == x){
                xIndex = i;
            }

            if(list.get(i) == x){
                yIndex = i;
            }
        }

        return xIndex/2 != yIndex/2  && getDepth(xIndex) == getDepth(yIndex);
    }

    public static int getDepth(int index){
        int depth = 0;
        while(index != 0){
            index /=2;
            depth ++;
        }
        return depth;
    }


    public static List<Integer> covert2List(TreeNode rootNode){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode != null){
                list.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTreeNode();
        System.out.println(isCousins(root,2,8 ));
    }
}
