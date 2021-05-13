package leetcode.easy;

/**
 * @author XIANG
 * @since 2020/8/31 9:32
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    //方法一：动态规划
    //思路和算法
    //假设 nums 数组的长度是 n，下标从 0 到 n - 1。
    //我们用 a_i 代表 nums[i]，用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
    //因此我们只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。那么我们如何求 f(i) 呢？我们可以考虑 a_i 单独成为一段还是加入 f(i - 1) 对应的那一段，这取决于 a_i 和 f(i - 1) + a_i 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int pre = 0;
        for (int num: nums) {
            pre = Math.max(num, pre + num);
            sum = Math.max(sum, pre);
        }
        return sum;
    }


    static class Status{
        public int lSum, rSum, mSum, iSum;
        public Status(int l, int r, int m, int i){
            lSum = l;
            rSum = r;
            mSum = m;
            iSum = i;
        }

    }

    public static int maxSubArray1(int[] nums) {
        return getStatusInfo(nums, 0, nums.length -1).iSum;
    }

    private static Status getStatusInfo(int[] nums, int begin, int end) {
        if(begin == end) return new Status(nums[begin],nums[begin],nums[begin],nums[begin]);
        int mid = (begin+end)>>1;
        Status lStatus = getStatusInfo(nums, begin, mid);
        Status rStatus = getStatusInfo(nums, mid+1, end);
        int l = Math.max(lStatus.lSum, lStatus.mSum + rStatus.lSum);
        int r =Math.max(rStatus.rSum, rStatus.mSum + lStatus.rSum);
        int m =lStatus.mSum + rStatus.mSum;
        int i =Math.max(Math.max(rStatus.iSum, lStatus.iSum), lStatus.rSum + rStatus.lSum );
        return new Status(l, r, m, i);

    }


    //暴力获取每一个字串和
    public static int maxSubArray2(int[] nums) {
        int finalSum = 0, length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = 0, count = 0;
            while (i + count < length) {
                sum += nums[i + count];
                if (sum > finalSum) {
                    finalSum = sum;
                }
                count++;
            }
        }
        return finalSum;
    }

}
