package leetcode.easy;

/**
 * Created by Mr.Wang on 2019/7/20.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int removeCount = 0;
        for(int i = 0; i + removeCount < nums.length; i++){
            nums[i] = nums[i + removeCount];
            //nums[i + removeCount] = 0;
            while(nums[i] == val && i + removeCount < nums.length){
                removeCount++;
                if(i + removeCount < nums.length){
                    nums[i] = nums[i + removeCount];
                    nums[i + removeCount] = 0;
                }
            }
        }
        return nums.length - removeCount;
    }

    public static void main(String[] args) {
        removeElement(new int[]{3,2,3},3);
    }
}
