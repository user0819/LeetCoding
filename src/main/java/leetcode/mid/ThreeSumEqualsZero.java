package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author wangxiang
 * @since 2020/5/11 13:01
 */
public class ThreeSumEqualsZero {
    public static void main(String[] args) {
        print(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


    /**
     * 暴力
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if( nums[i] + nums[j] +nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public static void print(List<List<Integer>> result){
        for (List<Integer> list: result) {
            System.out.println();
            for (Integer integer: list) {
                System.out.print(integer + ",");
            }
        }
    }
}
