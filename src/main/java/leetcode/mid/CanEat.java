package leetcode.mid;

import util.ArrayUtil;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * <p>
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount{i} 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries{i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * <p>
 * 你按照如下规则进行一场游戏：
 * <p>
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * <p>
 * 请你返回得到的数组 answer 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 * <p>
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangxiang
 * @since 2021/6/1 9:39
 */
public class CanEat {
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        //前缀和：吃i种糖果之前需要吃的个数
        long[] countPrefix = new long[candiesCount.length + 1];
        countPrefix[0] = 0;
        for (int i = 1; i < countPrefix.length; i++) {
            countPrefix[i] = countPrefix[i - 1] + candiesCount[i - 1];
        }

        boolean[] result = new boolean[queries.length];
        int type, day, dailyCap;
        for (int i = 0; i < queries.length; i++) {
            type = queries[i][0];
            day = queries[i][1];
            dailyCap = queries[i][2];
            //保证两点：
            //1.每天按最大数吃,吃完当天后，至少能吃到一颗最爱的糖果：即(day + 1) * dailyCap > countPrefix[type]
            //2.每天按最小数吃，吃到当天时，最爱的糖果没被吃完，即day < countPrefix[type + 1]
            result[i] = ((day + 1) > countPrefix[type] / dailyCap) && (day < countPrefix[type + 1]);
        }
        return result;
    }

    public static boolean[] canEat2(int[] candiesCount, int[][] queries) {
        //前缀和：吃i种糖果之前需要吃的个数
        long[] countPrefix = new long[candiesCount.length + 1];
        countPrefix[0] = 0;
        for (int i = 1; i < countPrefix.length; i++) {
            countPrefix[i] = countPrefix[i - 1] + candiesCount[i - 1];
        }

        boolean[] result = new boolean[queries.length];
        int type, day, dailyCap;
        for (int i = 0; i < queries.length; i++) {
            type = queries[i][0];
            day = queries[i][1];
            dailyCap = queries[i][2];
            //保证两点：
            //1.每天按最大数吃,吃完当天后，至少能吃到一颗最爱的糖果：即(day + 1) * dailyCap > countPrefix[type]
            //2.每天按最小数吃，吃到当天时，最爱的糖果没被吃完，即day < countPrefix[type + 1]
            result[i] = ((long) (day + 1) * dailyCap > countPrefix[type]) && (day < countPrefix[type + 1]);
        }
        return result;
    }


    public static void main(String[] args) {
        boolean[] result = canEat(new int[]{5, 2, 6, 4, 1}, new int[][]{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}});

        ArrayUtil.print(result);

        System.out.println(1000000000);
    }
}
