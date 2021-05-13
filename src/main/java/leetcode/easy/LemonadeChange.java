package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 *  顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 *  每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 *  注意，一开始你手头没有任何零钱。
 *
 *  如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 *  示例 1：
 *
 *  输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 *
 *
 *  示例 2：
 *
 *  输入：[5,5,10]
 * 输出：true
 *
 *
 *  示例 3：
 *
 *  输入：[10,10]
 * 输出：false
 *
 *
 *  示例 4：
 *
 *  输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 *
 *
 *
 *
 *  提示：
 *
 *
 *  0 <= bills.length <= 10000
 *  bills[i] 不是 5 就是 10 或是 20
 *
 *  Related Topics 贪心算法
 *  👍 220 👎 0
 *
 *
 * leetcode submit region begin(Prohibit modification and deletion)
 * @author XIANG
 * @since 2021/3/29 19:14
 */
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> money2Count = new HashMap<>();
        money2Count.put(5,0);
        money2Count.put(10,0);
        money2Count.put(20,0);

        for (int i = 0; i < bills.length; i++) {
            //此次收取
            int total = bills[i];
            money2Count.put(total,money2Count.get(total) + 1);

            //需要找零
            int change = total - 5;

            //优先用10
            if(change >= 10 && money2Count.get(10) >= 1){
                money2Count.put(10,money2Count.get(10) - 1);
                change -=10;
            }

            //不够的用5
            int fiveNum = change / 5;
            if (money2Count.get(5) >= fiveNum){
                money2Count.put(5,money2Count.get(5) - fiveNum);
            }else{
                return false;
            }

        }
        System.out.println(money2Count);
        return true;
    }

    //直接枚举
    public boolean lemonadeChange2(int[] bills) {
        //统计店员所拥有的5元和10元的数量（20元的不需要统计，
        //因为顾客只能使用5元，10元和20元，而20元是没法
        // 给顾客找零的）
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                //如果顾客使用的是5元，不用找零，5元数量加1
                five++;
            } else if (bill == 10) {
                //如果顾客使用的是10元，需要找他5元，所以
                //5元数量减1,10元数量加1
                five--;
                ten++;
            } else if (ten > 0) {
                //否则顾客使用的只能是20元，顾客使用20元的时候，
                //如果我们有10元的，要尽量先给他10元的，然后再
                //给他5元的，所以这里5元和10元数量都要减1
                ten--;
                five--;
            } else {
                //如果顾客使用的是20元，而店员没有10元的，
                //就只能给他找3个5元的，所以5元的数量要减3
                five -= 3;
            }

            //上面我们找零的时候并没有判断5元的数量，如果5元的
            //数量小于0，说明上面某一步找零的时候5元的不够了，
            //也就是说没法给顾客找零，直接返回false即可
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5}));
    }
}
