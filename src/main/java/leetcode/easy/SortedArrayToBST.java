package leetcode.easy;

/**
 * Created by Mr.Wang on 2019/6/27.
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {

        return getSortedTreeNode(nums,0,nums.length-1);
    }

    public static TreeNode getSortedTreeNode(int[] nums, int start, int end){
        if(end <= start){
            return null;
        }
        int middle = (end + start)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = getSortedTreeNode(nums,start,middle-1);
        root.right = getSortedTreeNode(nums,middle+1,end);
        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
