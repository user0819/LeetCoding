package leetcode.easy;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
 * 的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * Related Topics 贪心算法 数组
 * 👍 326 👎 0
 *
 * @author wangxiang
 * @since 2021/3/29 19:44
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }


    //连续三个0时，中间可种
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 0) {
            return false;
        }

        if (len == 1 && flowerbed[0] == 0) {
            n--;
            flowerbed[0] = 1;
        }

        if (len == 2 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            flowerbed[0] = 1;
        }

        for (int i = 1; i < flowerbed.length - 1; ) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
                i += 2;
            } else {
                i++;
            }
        }

        if (n > 0) {
            return false;
        } else {
            return true;
        }
    }


    //当前为1时，跳一格可种
    //
    //【1】当遍历到index遇到1时，说明这个位置有花，那必然从index+2的位置才有可能种花，因此当碰到1时直接跳过下一格。
    //【2】当遍历到index遇到0时，由于每次碰到1都是跳两格，因此前一格必定是0，此时只需要判断下一格是不是1即可得出index这一格能不能种花，如果能种则令n减一，然后这个位置就按照遇到1时处理，即跳两格；如果index的后一格是1，说明这个位置不能种花且之后两格也不可能种花（参照【1】），直接跳过3格。
    //
    //当n减为0时，说明可以种入n朵花，则可以直接退出遍历返回true；如果遍历结束n没有减到0，说明最多种入的花的数量小于n，则返回false。
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0;) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }

}
