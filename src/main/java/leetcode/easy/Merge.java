package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * 88
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while(m>=0 && n>=0){
            nums1[i--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
        }
        while(n>=0){
            nums1[i--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};
        merge(a,3,b,3);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
