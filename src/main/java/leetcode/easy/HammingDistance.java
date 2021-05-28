package leetcode.easy;

/**
 *
 * 461. 汉明距离
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 *
 * @author wangxiang
 * @since 2021/5/27 11:23
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for(int i = 0; i<=31; i++){
            if((1 & (xor >> i)) == 1){
                count++;
            }
        }
        return  count;
    }

    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor != 0){
            if((xor & 1) == 1){
                count++;
            }
            xor >>= 1;
        }
        return  count;
    }

    //直接跳过为0的位数
    public static int hammingDistance4(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor != 0){
            xor &= (xor -1);
            count++;
        }
        return  count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(Integer.MAX_VALUE,Integer.MIN_VALUE));
        System.out.println(hammingDistance2(Integer.MAX_VALUE,Integer.MIN_VALUE));
        System.out.println(hammingDistance3(Integer.MAX_VALUE,Integer.MIN_VALUE));
    }
}
