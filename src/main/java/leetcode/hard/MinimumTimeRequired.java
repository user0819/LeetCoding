package leetcode.hard;

import java.util.Arrays;

/**
 * 1723. 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * <p>
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
 * 工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * <p>
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 * <p>
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangxiang
 * @since 2021/5/8 10:30
 */
public class MinimumTimeRequired {
    public static int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        Arrays.sort(jobs);
        for (int i = jobs.length - 1; i >= 0; i--) {
            int minWorkerIndex = findMinIndex(workers);
            workers[minWorkerIndex] = workers[minWorkerIndex] + jobs[i];
        }

        int maxHour = 0;
        for (int i = 0; i < workers.length; i++) {
           maxHour = Math.max(workers[i], maxHour);
        }
        return maxHour;
    }

    private static int findMinIndex(int[] workers) {
        int minIndex = 0;
        for (int i = 1; i < workers.length; i++) {
            if (workers[i] < workers[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    public int minimumTimeRequired2(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            int x = Integer.numberOfTrailingZeros(i);
            int y = i - (1 << x);
            sum[i] = sum[y] + jobs[x];
        }

        int[][] dp = new int[k][1 << n];
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = sum[i];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                int minn = Integer.MAX_VALUE;
                for (int x = j; x != 0; x = (x - 1) & j) {
                    minn = Math.min(minn, Math.max(dp[i - 1][j - x], sum[x]));
                }
                dp[i][j] = minn;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }

    public static void main(String[] args) {
        System.out.println(minimumTimeRequired(new int[]{8,12,15,18,20,2,9}, 4));
    }
}
