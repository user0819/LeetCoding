package leetcode.easy;


//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length -1;
        int mid = 0;

        while(start <= end){
            mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end--;
            }else{
                start++;
            }
        }
        if(target > nums[mid] ){
            return ++mid;
        }else{
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2,3,4,5}, 6));
    }
}
