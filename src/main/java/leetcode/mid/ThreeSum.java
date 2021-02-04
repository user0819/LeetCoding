package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
 * 复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * Related Topics 数组 双指针
 *
 * @author wangxiang
 * @since 2021/2/4 9:56
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum3(new int[]{0, 0, 0, 0}));
    }

    //三层for循环，结果可以出来，但会超时
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //使用HashMap降低时间复杂度（O(n^2)）
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j])) {
                    set.add(Arrays.asList(nums[i], nums[j], target - nums[j]));
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 枚举 a
        for (int a = 0; a < length; ++a) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int target = -nums[a];

            int c = length - 1;
            for (int b = a + 1; b < length; ++b) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                while (b < c && nums[b] + nums[c] > target) {
                    --c;
                }
                if (b == c) {
                    break;
                }
                if (nums[b] + nums[c] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
