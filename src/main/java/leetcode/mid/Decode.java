package leetcode.mid;

import util.ArrayUtil;

/**
 * 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author XIANG
 * @since 2021/5/12 18:20
 */
public class Decode {



    /**
     * 前提知识：异或操作，符合交换律、结合律
     *
    * 先求result[0]
    * result[0]=(result[0]^result[1]^result[2]^..^result[n-1]) ^ (result[1]^result[2]^..^result[n-1])
    * result[0]=(1^2^3^..^n) ^ (result[1]^result[2]^..^result[n-1])
    * result[0]=(1^2^3^..^n) ^ (encoded[1] ^ encoded[3] ^ ... ^ encoded[n-2])
    */
    public static int[] decode(int[] encoded) {
        int[] result = new int[encoded.length + 1];

        //前n个数的异或值
        int sumXor = 0;
        for (int i = 1; i <= result.length; i++) {
            sumXor ^= i;
        }

        //除了result[0]外所有数的异或值
        int sumXorWithoutFirst = 0;
        for (int i = 1; i <= result.length - 2; i += 2) {
            sumXorWithoutFirst ^= encoded[i];
        }

        result[0] = sumXor ^ sumXorWithoutFirst;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = decode(new int[]{6,5,4,6});
        ArrayUtil.print(result);
    }
}
