package leetcode.hard;

import java.util.TreeSet;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 * <p>
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumSubMatrix {
    //暴力枚举，肯定可以
    public static int maxSumSubMatrix(int[][] matrix, int k) {
        int finalResult = Integer.MIN_VALUE;

        int width = matrix.length;
        int length = matrix[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                int thisBitResult = Integer.MIN_VALUE;

                //长度
                for (int l = 1; l <= length - j; l++) {
                    //宽度
                    for (int w = 1; w <= width - i; w++) {
                        int thisWLResult = 0;
                        for (int lStep = 0; lStep < l; lStep++) {
                            for (int wStep = 0; wStep < w; wStep++) {
                                thisWLResult += matrix[i + wStep][j + lStep];
                            }
                        }
                        if (thisWLResult <= k) {
                            thisBitResult = Math.max(thisBitResult, thisWLResult);
                        }
                    }
                }


                finalResult = Math.max(finalResult, thisBitResult);
            }
        }
        return finalResult;
    }


    /**
     * 我们枚举矩形的上下边界，并计算出该边界内每列的元素和，则原问题转换成了如下一维问题：
     * <p>
     * 给定一个整数数组和一个整数 k，计算该数组的最大区间和，要求区间和不超过 k。
     *
     * 使用S(i)作为数组i位的前缀和，则区间 [l,r)可表示为S(r) - S(l)
     * 此题即为获取最大的S(r) - S(l)
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int maxSumSubMatrix2(int[][] matrix, int k) {
        int width = matrix.length;
        int length = matrix[0].length;

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < width; i++) {       // 枚举上边界
            int[] sum = new int[length];
            for (int j = i; j < width; j++) {   // 枚举下边界
                for (int l = 0; l < length; l++) {
                    sum[l] += matrix[j][l];             // 更新每列的元素和,  题解转换为获取数组sum的最大区间和
                }

                //获取数组sum的最大区间和
                TreeSet<Integer> treeSet = new TreeSet<>();
                int s = 0;
                treeSet.add(s);
                for (int v : sum) {
                    s += v;
                    Integer ceil = treeSet.ceiling(s - k);
                    if (ceil != null) {
                        result = Math.max(result, s - ceil);
                    }

                    treeSet.add(s);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(maxSumSubMatrix2(new int[][]{{2, 2, -1}}, 4));
    }
}
