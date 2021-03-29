package leetcode.mid;

/**
 * 初始时有 n 个灯泡关闭。
 * <p>
 * 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
 * <p>
 * 第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。
 * <p>
 * 找出 n 轮后有多少个亮着的灯泡。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * <p>
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：1
 *
 * @author wangxiang
 * @since 2021/2/19 17:00
 */
public class BulbSwitch1 {
    public static void main(String[] args) {
        System.out.println(bulbSwitch(1000000));
        System.out.println(bulbSwitch2(1000000));
        System.out.println(bulbSwitch3(1000000));
    }

    public static int bulbSwitch(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = -1;
        }

        //每一轮，如果是i的倍数，则翻转
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j <= n) {
                if (j % i == 0) {
                    array[j - 1] = -array[j - 1];
                }
                j++;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == 1) {
                result++;
            }
        }
        return result;
    }

    //第N个灯泡，N有几个约数，灯泡就会翻转几次
    public static int bulbSwitch2(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += divisorNum(i) & 1;
        }
        return result;
    }

    //计算约数个数
    public static int divisorNum(int n) {
        int num = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    num += 1;
                } else {
                    num += 2;
                }
            }
        }
        return num;
    }

    //根据bulbSwitch2继续推导，只有约数个数为奇数的才会亮，即只需要得到N中有几个数字满足y=x*x
    public static int bulbSwitch3(int n) {
        int result = 0;
        int i = 1;
        while (i * i <= n) {
            i++;
            result++;
        }
        return result;
    }

}
