package leetcode.mid;

import util.ArrayUtil;

/**
 * 1310. 子数组异或查询
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * <p>
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * <p>
 * 并返回一个包含给定查询 queries 所有结果的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 * <p>
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangxiang
 * @since 2021/5/12 19:10
 */
public class XorQueries {
    //prefixXor[i]  = arr[0] ^ arr[1] ^ arr[2] ^ arr[3] ^...^ arr[i-1]
    // 则题解 为 prefixXor[end + 1] ^ prefixXor[start]
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXor = new int[arr.length + 1];

        prefixXor[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefixXor[start] ^ prefixXor[end + 1];
        }

        return result;
    }

    public static void main(String[] args) {
        //int[] result = xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}});
        int[] result = xorQueries(new int[]{16}, new int[][]{ {0, 0},{0, 0},{0, 0},{0, 0}});
        ArrayUtil.print(result);
    }
}
