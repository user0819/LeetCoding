package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个房屋数组houses 和一个整数 k ，其中 houses[i] 是第 i 栋房子在一条街上的位置，现需要在这条街上安排 k 个邮筒。
 * <p>
 * 请你返回每栋房子与离它最近的邮筒之间的距离的 最小 总和。
 * <p>
 * 答案保证在 32 位有符号整数范围以内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：houses = [1,4,8,10,20], k = 3
 * 输出：5
 * 解释：将邮筒分别安放在位置 3， 9 和 20 处。
 * 每个房子到最近邮筒的距离和为 |3-1| + |4-3| + |9-8| + |10-9| + |20-20| = 5 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：houses = [2,3,5,12,18], k = 2
 * 输出：9
 * 解释：将邮筒分别安放在位置 3 和 14 处。
 * 每个房子到最近邮筒距离和为 |2-3| + |3-3| + |5-3| + |12-14| + |18-14| = 9 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：houses = [7,4,6,1], k = 1
 * 输出：8
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：houses = [3,6,14,10], k = 4
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == houses.length
 * 1 <= n <= 100
 * 1 <= houses[i] <= 10^4
 * 1 <= k <= n
 * 数组 houses 中的整数互不相同。
 * <p>
 * Related Topics 数学 动态规划
 *
 * @author XIANG
 * @since 2021/1/5 11:57
 */
public class MinDistance {
    public static int minDistance(int[] houses, int k) {
        if (k >= houses.length) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> splitArrays = splitArray(houses, k);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : splitArrays.entrySet()) {
            result += thisTotal(integerIntegerEntry.getKey(), integerIntegerEntry.getValue(), houses);
        }
        return result;
    }

    public static Map<Integer, Integer> splitArray(int[] houses, int k) {
        return new HashMap<>();
    }

    public static int thisTotal(int startIndex, int endIndex, int[] houses) {
        int total = 0;
        int mid = (houses[startIndex] + houses[endIndex]) / 2;
        for (int i = startIndex; i <= endIndex; i++) {
            total += Math.abs(mid - houses[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(minDistance(new int[]{1, 4, 8, 10, 20}, 3));
    }
}
