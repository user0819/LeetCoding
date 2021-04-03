package leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1046
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * <p>
 * <p>
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * Related Topics 堆 贪心算法
 *
 * @author wangxiang
 * @since 2021/3/5 11:13
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight2(new int[]{2, 7, 4, 1, 8, 1}));
    }

    //暴力法 (超时)
    //每次都把最大的两个放后面
    //O（n*n*log(n)）
    public static int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        if (stones.length < 2) {
            return stones[0];
        }

        Arrays.sort(stones);
        while (stones[stones.length - 2] != 0) {
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }


    public static int lastStoneWeight2(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : stones) {
            queue.offer(num);
        }

        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if (first > second) {
                queue.offer(first - second);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}