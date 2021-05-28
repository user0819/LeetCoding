package leetcode.mid;

/**
 * 1035. 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * <p>
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * <p>
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * <p>
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 * <p>
 *  示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 *
 * @author wangxiang
 * @since 2021/5/21 9:58
 */
public class MaxUncrossedLines {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        return findMaxNum(nums1, nums2, 0, 0);
    }

    public static int findMaxNum(int[] nums1, int[] nums2, int nums1Index, int nums2Index) {
        if (nums1Index >= nums1.length || nums2Index >= nums2.length) {
            return 0;
        }

        //从num1开始找
        int i = nums1Index, j = nums2Index;
        boolean match = false;
        for (; i < nums1.length; i++) {
            for (j = nums2Index; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    match = true;
                    break;
                }
            }
            if (match) {
                break;
            }
        }

        //从num1找配对找不到，那从num2找，肯定也找不到，就直接返回0
        if (!match) {
            return 0;
        }

        //从num2开始找配对
        int m, n = nums1Index;
        boolean match2 = false;
        for (m = nums2Index; m < nums2.length; m++) {
            for (n = nums1Index; n < nums1.length; n++) {
                if (nums2[m] == nums1[n]) {
                    match2 = true;
                    break;
                }
            }
            if (match2) {
                break;
            }
        }


        int fromNum1Result = 1 + findMaxNum(nums1, nums2, i + 1, j + 1);
        int fromNum2Result = 1 + findMaxNum(nums1, nums2, n + 1, m + 1);
        return Math.max(fromNum1Result, fromNum2Result);
    }

    public static void main(String[] args) {
//        System.out.println(maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
//        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
//        System.out.println(maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
//        System.out.println(maxUncrossedLines(new int[]{}, new int[]{1}));
        System.out.println(maxUncrossedLines(new int[]{4,2,1,4,2,2,5,1,4,4,1,2,4,2,1,4,1,4,1,5}, new int[]{4,3,4,4,3,3,1,1,4,2,3,2,5,1,2}));
    }
}
