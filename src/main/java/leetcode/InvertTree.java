package leetcode;



import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mr.Wang on 2019/6/15.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode returnNode = root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode queueHead, temp;
        while(!queue.isEmpty()){
            queueHead = queue.poll();
            if(queueHead.left!=null){queue.offer(queueHead.left);}
            if(queueHead.left!=null){queue.offer(queueHead.right);}

            temp = queueHead.left;
            queueHead.left = queueHead.right;
            queueHead.right = temp;
        }

        return returnNode;
    }
}



