package leetcode.mid;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLength {
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 2, 3, 2, 1}));
        ;
    }

    //暴力（超出时间限制）
    public static int findLength(int[] A, int[] B) {
        int maxLength = 0;
        int ALen = A.length;
        int BLen = B.length;
        for (int a = 0; a < ALen; a++) {
            for (int b = 0; b < BLen; b++) {
                int count = 0;
                while (b + count < BLen && a + count < ALen && B[b + count] == A[a + count]) {
                    count++;
                }
                maxLength = Math.max(count, maxLength);
            }
        }
        return maxLength;
    }

    //如果 A[i] == B[j]，那么我们知道 A[i:] 与 B[j:] 的最长公共前缀为 A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加一，否则我们知道 A[i:] 与 B[j:] 的最长公共前缀为零。
    //这样我们就可以提出动态规划的解法：令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
    public static int findLength2(int[] A, int[] B) {
        int maxLength = 0;
        int ALen = A.length;
        int BLen = B.length;
        int[][] dp = new int[ALen + 1][BLen + 1];
        for (int i = ALen - 1; i >= 0; i--) {
            for (int j = BLen - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }


    //https://pic.leetcode-cn.com/9ed48b9b51214a8bafffcad17356d438b4c969b4999623247278d23f1e43977f-%E9%94%99%E5%BC%80%E6%AF%94%E8%BE%83.gif
    public static int findLength3(int[] A, int[] B) {
        return 3;
    }
}
