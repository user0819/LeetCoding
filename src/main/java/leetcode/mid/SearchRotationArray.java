package leetcode.mid;

/**
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 * @author wangxiang
 * @since 2021/2/19 10:20
 */
public class SearchRotationArray {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int simpleSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        int mid, low = 0, high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[low] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[low]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 low 和 high
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
