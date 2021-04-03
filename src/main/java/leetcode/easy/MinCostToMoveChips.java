package leetcode.easy;

/**
 * 1217
 *
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 *
 *  你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *
 *
 *  将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 *  将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 *
 *
 *  最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 *
 *  返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 *
 *
 *
 *  示例 1：
 *
 *  输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 *
 *
 *  示例 2：
 *
 *  输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= chips.length <= 100
 *  1 <= chips[i] <= 10^9
 *
 *  Related Topics 贪心算法 数组 数学
 *  👍 81 👎 0
 * @author wangxiang
 * @since 2021/3/30 16:51
 */
public class MinCostToMoveChips {
    public static void main(String[] args) {
        System.out.println(minCostToMoveChips2(new int[]{2,2,2,3,3}));
    }

    public static int minCostToMoveChips(int[] position) {
        int maxIndex = 0;
        for (int i = 0; i < position.length; i++) {
            if(position[i] > maxIndex){
                maxIndex = position[i];
            }
        }

        if(maxIndex == 0 || maxIndex == 1){
            return 0;
        }

        int[] array = new int[maxIndex];
        for (int i = 0; i < position.length; i++) {
            int index = position[i] -1;
            array[index] = array[index] + 1;
        }

        for (int i = 0; i <= array.length - 3; i++) {
            array[i+2] = array[i+2] + array[i];
        }

        return Math.min(array[array.length -1], array[array.length -2]);
    }


    //最终其实就是比较奇数位&偶数位，取最小值
    public static int minCostToMoveChips2(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if(position[i]%2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(even,odd);
    }
}
