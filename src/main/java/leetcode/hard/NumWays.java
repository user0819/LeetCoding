package leetcode.hard;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * 通过次数10,370提交次数21,655
 *
 * @author wangxiang
 * @since 2021/5/13 17:18
 */
public class NumWays {
    static int mod = 1000000007;

    // 深度优先遍历（遍历每一种可能走过的路线，并记录能回到原点的路线）
    public static int numWays(int steps, int arrLen) {
        AtomicInteger nums = new AtomicInteger(0);
        dfs(0, 1, steps, arrLen, nums);
        return nums.get();
    }

    public static void dfs(int currentStep, int currentIndex, int steps, int arrLens, AtomicInteger nums) {
        if (currentStep > steps || currentIndex < 1 || currentIndex > arrLens) {
            return;
        }
        if (currentStep == steps) {
            if (currentIndex == 1) {
                nums.incrementAndGet();
            }
            return;
        }

        dfs(currentStep + 1, currentIndex - 1, steps, arrLens, nums);
        dfs(currentStep + 1, currentIndex, steps, arrLens, nums);
        dfs(currentStep + 1, currentIndex + 1, steps, arrLens, nums);
    }

    // 深度优先遍历（遍历每一种可能走过的路线，并记录能回到原点的路线）
    //possibleCache[i][j]记录在第i个位置时，剩余j步，可以到原点的可能性
    public static int numWaysWithCache(int steps, int arrLen) {
        Integer[][] possibleCache = new Integer[arrLen][steps + 1];
        return dfsWithCache(0, steps, possibleCache);
    }

    //在numWaysWithCache的基础上优化数组长度
    public static int numWaysWithCacheV2(int steps, int arrLen) {
        int maxColumn = Math.min(arrLen, steps);
        Integer[][] possibleCache = new Integer[maxColumn][steps + 1];
        return dfsWithCache(0, steps, possibleCache);
    }

    public static int dfsWithCache(int currentIndex, int leftStep, Integer[][] cache) {
        if (currentIndex < 0 || currentIndex >= cache.length || leftStep < 0) {
            return 0;
        }
        if (cache[currentIndex][leftStep] != null) {
            return cache[currentIndex][leftStep];
        }


        if (leftStep == 0) {
            if (currentIndex == 0) {
                cache[currentIndex][leftStep] = 1;
            } else {
                cache[currentIndex][leftStep] = 0;
            }
        } else {
            cache[currentIndex][leftStep] = ((dfsWithCache(currentIndex - 1, leftStep - 1, cache) + dfsWithCache(currentIndex, leftStep - 1, cache)) % mod + dfsWithCache(currentIndex + 1, leftStep - 1, cache)) % mod;
        }
        return cache[currentIndex][leftStep];
    }


    //用 dp[i][j] 表示在 i步操作之后，指针位于下标 j 的方案数
    public static int numWaysWithAnswer(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen , steps);
        int[][] dp = new int[steps + 1][maxColumn];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < maxColumn; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                if (j + 1 < maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }


    public static void main(String[] args) {
        //System.out.println(numWaysWithCache(4, 2));
        System.out.println(numWaysWithCache(3, 2));
        System.out.println(numWaysWithAnswer(430, 148488));
        //System.out.println( 1000000006 *3);
    }
}
