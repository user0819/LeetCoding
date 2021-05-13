package leetcode.hard;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 *  示例 1：
 *
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 *
 *  示例 2：
 *
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 *
 *
 *  提示：
 *
 *
 *  n == height.length
 *  0 <= n <= 3 * 104
 *  0 <= height[i] <= 105
 *
 *  Related Topics 栈 数组 双指针 动态规划
 * @author XIANG
 * @since 2021/3/2 10:19
 */
public class Trap {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{}));
    }
    public static int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        return calculateArea(height, 0, height.length -1);
    }

    public static int calculateArea(int[] height, int start, int end) {
        if(start < 0 || end > height.length || start == end){
            return 0;
        }
        //找到最高
        int tallestIndex = findTallest(height,start, end);
        //找到左边最高
        int leftTallestIndex = findLeftTallest(height,start, tallestIndex);
        //找到右边最高
        int rightTallestIndex = findRightTallest(height,tallestIndex, end);

        //计算leftTallestIndex->tallestIndex中的可接水面积
        int leftArea = calculateSolidArea(height,leftTallestIndex, tallestIndex);
        //计算tallestIndex->rightTallestIndex中的可接水面积
        int rightArea = calculateSolidArea(height,tallestIndex, rightTallestIndex);
        //递归计算
        return leftArea + rightArea + calculateArea(height, start, leftTallestIndex) + calculateArea(height, rightTallestIndex, end);
    }

    public static int calculateSolidArea(int[] height, int start, int end) {
        if(start == end){
            return 0;
        }
        int total = Math.min(height[start], height[end]) * (end - start - 1);
        int solidArea = 0;
        for (int i = start + 1; i < end; i++) {
            solidArea +=height[i];
        }
        return total - solidArea;
    }

    public static int findTallest(int[] height, int start, int end) {
        int tallest = start;
        for (int i = start; i <= end; i++) {
            if (height[i] > height[tallest]){
                tallest = i;
            }
        }
        return tallest;
    }
    public static int findLeftTallest(int[] height, int start, int end) {
        int tallest = start;
        for (int i = start; i < end; i++) {
            if (height[i] > height[tallest]){
                tallest = i;
            }
        }
        return tallest;
    }

    public static int findRightTallest(int[] height, int start, int end) {
        int tallest = end;
        for (int i = start + 1; i < end; i++) {
            if (height[i] > height[tallest]){
                tallest = i;
            }
        }
        return tallest;
    }


    //按行求
    public static int trap2(int[] height) {
        int sum = 0;
        int max = getMax(height);//找到最大的高度，以便遍历。
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private static int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }


    public static int trap3(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
