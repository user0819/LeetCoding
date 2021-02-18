package leetcode.mid;

/**
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * <p>
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （thres
 * hold 的值)。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,1,1,1], k = 1, threshold = 0
 * 输出：5
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * 输出：6
 * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
 * 输出：1
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：arr = [4,4,4,4], k = 4, threshold = 1
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^4
 * 1 <= k <= arr.length
 * 0 <= threshold <= 10^4
 * <p>
 * Related Topics 数组
 * 👍 27 👎 0
 *
 * @author wangxiang
 * @since 2021/2/18 11:16
 */
public class NumOfSubArrays {

    public static void main(String[] args) {
        System.out.println(numOfSubArrays2(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
    }

    //暴力，超时了
    public static int numOfSubArrays(int[] arr, int k, int threshold) {

        int sum, count = 0, total = k * threshold;
        for (int i = 0; i <= arr.length - k; i++) {
            sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }
            if (sum >= total) {
                count++;
            }
        }
        return count;
    }


    //滑动窗口，避免无效重复加减
    public static int numOfSubArrays2(int[] arr, int k, int threshold) {

        int sum = 0, count = 0, total = k * threshold;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= total) {
            count++;
        }

        for (int i = 1; i <= arr.length - k; i++) {
            sum = sum - arr[i - 1] + arr[i + k - 1];
            if (sum >= total) {
                count++;
            }
        }
        return count;
    }
}
