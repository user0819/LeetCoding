package leetcode.easy;

/**
 * @author wangxiang
 * @since 2021/4/27 19:59
 */
public class LastRemaining {

    public static int lastRemaining(int n, int m) {
        TreeNode previousNode = initHead(n);
        TreeNode thisNode = previousNode.right;
        int shoutCount = 0;
        int leavePersonCount = n;
        while (leavePersonCount > 1) {
            shoutCount++;
            if (shoutCount > m) {
                shoutCount %= m;
            }

            if (shoutCount == m) {
                previousNode.right = thisNode.right;
                thisNode = thisNode.right;
                leavePersonCount--;
                shoutCount = 0;
            } else {
                previousNode = thisNode;
                thisNode = thisNode.right;
            }
        }
        return thisNode.val;
    }

    public static TreeNode initHead(int n) {
        TreeNode head = new TreeNode(-1);
        TreeNode tmp = head;
        for (int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(i);
            tmp.right = node;
            tmp = node;
        }
        tmp.right = head.right;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 1));
    }
}
