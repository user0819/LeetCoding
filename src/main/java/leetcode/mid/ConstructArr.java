package leetcode.mid;

import util.ArrayUtil;

/**
 * 剑指 Offer 66. 构建乘积数组
 * <p>
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class ConstructArr {

    /**
     * 直接除法
     * （存在0时无法通过）
     */
    public static int[] constructArr(int[] a) {
        int[] B = new int[a.length];
        int multiplyAll = 1;
        for (int num : a) {
            multiplyAll *= num;
        }

        for (int i = 0; i < a.length; i++) {
            B[i] = multiplyAll / a[i];
        }

        return B;
    }

    public static int[] constructArr2(int[] a) {
        int[] B = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int multiplyAll = 1;
            for (int j = 0; j < a.length; j++) {
                if (j != i) {
                    multiplyAll *= a[j];
                }
            }
            B[i] = multiplyAll;
        }
        return B;
    }

    /**
     * 前缀和 & 后缀和
     */
    public static int[] constructArr3(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        int n = a.length;
        int[] B = new int[n];
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        prefix[0] = suffix[n - 1] = 1;

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] * a[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * a[i + 1];
        }

        for (int i = 0; i < n; i++) {
            B[i] = prefix[i] * suffix[i];
        }
        return B;
    }


    public static void main(String[] args) {
        int[] result = constructArr2(new int[]{1, 2, 3, 4, 5});
        int[] result2 = constructArr3(new int[]{1, 2, 3, 4, 5});
        ArrayUtil.print(result);
        System.out.println();
        ArrayUtil.print(result2);
        System.out.println();
    }
}
