package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从 list = {1,2,3..., n} 中依序读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * <p>
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * <p>
 * <p>
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。
 * <p>
 * 题目数据保证答案是唯一的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= target.length <= 100
 * 1 <= target[i] <= 100
 * 1 <= n <= 100
 * target 是严格递增的
 *
 * @author wangxiang
 * @since 2021/2/25 19:26
 */
public class BuildArray {
    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1,2}, 3));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (i == target[j]) {
                j++;
                result.add("Push");
            }else{
                result.add("Push");
                result.add("Pop");
            }

        }
        return result;
    }
}
