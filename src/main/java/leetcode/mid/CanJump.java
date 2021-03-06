package leetcode.mid;

/**
 *  55
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 *  数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 *  判断你是否能够到达最后一个下标。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 *
 *  示例 2：
 *
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= nums.length <= 3 * 104
 *  0 <= nums[i] <= 105
 *
 *  Related Topics 贪心算法 数组
 *  👍 1115 👎 0
 * @author XIANG
 * @since 2021/3/31 11:36
 */
public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump2(new int[]{2,3,1,1,4}));
    }

    //找到能跳到末尾的最小index，再找到能跳到index的，直到index回到0
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return true;
        }
        int targetIndex = len - 1;
        while(targetIndex != 0){
            targetIndex = canJumpToIndex(nums, targetIndex);
            if(targetIndex == -1){
                return false;
            }
        }
        return true;
    }
    public static int canJumpToIndex(int[] nums, int targetIndex){
        for (int i = 0; i < targetIndex; i++) {
            if(nums[i] + i >= targetIndex){
                return i;
            }
        }
        return -1;
    }

    //官方解答
    public static boolean canJump2(int[] nums){
        int maxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i <= maxRight){
                maxRight = Math.max(maxRight, i + nums[i]);
                if(maxRight >= nums.length -1){
                    return true;
                }
            }
        }
        return false;
    }


    //同思路他人更优解:从末尾反查
    public static boolean canJump3(int[] nums){
        int canJumpIndex = nums.length - 1;

        for (int i = canJumpIndex -1; i >= 0 ; i--) {
            if (nums[i] + i >= canJumpIndex){
                canJumpIndex = i;
            }
        }
        return canJumpIndex == 0;
    }
}
