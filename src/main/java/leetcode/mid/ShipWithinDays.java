package leetcode.mid;

/**
 * 1011 在D天送达包裹的能力
 * <p>
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
 * 0) 是不允许的。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * <p>
 * Related Topics 数组 二分查找
 * 👍 246 👎 0
 *
 * @author XIANG
 * @since 2021/4/26 11:38
 */
public class ShipWithinDays {
    /**
     * 1.根据sum(weights)和 D 计算平均值 average
     * 2.遍历weights，获取最大值 maxSingle
     * 3.最低载重: startValue = Math.max(average, maxSingle)
     * 4.按startValue装载的话，天数不一定能满足，所以startValue自增并判断是否符合
     *
     * @param weights
     * @param D
     * @return
     */
    public static int shipWithinDays(int[] weights, int D) {
        int length = weights.length;
        int sum = 0;
        int maxSingle = 0;
        for (int i = 0; i < length; i++) {
            sum += weights[i];
            maxSingle = Math.max(maxSingle, weights[i]);
        }

        if (D >= length) {
            return maxSingle;
        }

        int average = (int) Math.ceil((double) sum / length);

        int startWeight = Math.max(average, maxSingle);
        int result = 0;

        while (true) {
            int count = 1;
            int tmpSum = 0;
            for (int i = 0; i < length; i++) {
                if (tmpSum + weights[i] <= startWeight) {
                    tmpSum += weights[i];
                    result = Math.max(tmpSum, result);
                } else {
                    tmpSum = weights[i];
                    count++;
                }
            }
            startWeight++;

            if (count <= D) {
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
         System.out.println(shipWithinDays(new int[]{}, 3));
    }
}
