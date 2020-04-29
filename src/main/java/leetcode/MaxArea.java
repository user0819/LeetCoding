package leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * @author wangxiang
 * @since 2020/4/11 13:33
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxAreaTwoPoint(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 暴力法
     * 获取所有可能
     * @param height
     * @return
     */
    public static int maxAreaForce(int[] height) {
        int length = height.length;
        int result = 0;

        int lower, newArea;
        for (int width = length - 1; width >= 1; width--) {
            for (int i = 0; i < length && i + width < length; i++) {
                lower = Math.min(height[i], height[i + width]);
                newArea = lower * width;
                if (newArea > result) {
                    result = newArea;
                }
            }
        }
        return result;
    }

    /**
     * 双指针
     * 每次低位移动
     * @param height
     * @return
     */
    public static int maxAreaTwoPoint(int[] height) {
        int result = 0, l = 0, r = height.length - 1;
        while (l < r) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}
