package leetcode.hard;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 810. 黑板异或游戏
 * 黑板上写着一个非负整数数组 nums[i] 。
 * Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。
 * 如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 
 * (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
 * <p>
 * 换种说法就是，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
 * <p>
 * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [1, 1, 2]
 * 输出: false
 * 解释:
 * Alice 有两个选择: 擦掉数字 1 或 2。
 * 如果擦掉 1, 数组变成 [1, 2]。剩余数字按位异或得到 1 XOR 2 = 3。那么 Bob 可以擦掉任意数字，因为 Alice 会成为擦掉最后一个数字的人，她总是会输。
 * 如果 Alice 擦掉 2，那么数组变成[1, 1]。剩余数字按位异或得到 1 XOR 1 = 0。Alice 仍然会输掉游戏。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * 0 <= nums[i] <= 2^16
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chalkboard-xor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XorGame {

    public static void main(String[] args) {
        System.out.println(xorGame(new int[]{44661,28364,19938,14074,4055,44908,63795,28845,57687,4186,6821,8824,47140,13353,50193,31875,56118,60397,32302,16190,41830,16703,54905,12796,60720,28280,32252,26152,53157,16533,23351,35532,9499,63077,61452,40746,32821,54584,21052,40120,51748,27735,17669,57930,6037,38216,30126,54687,63415,60517,29276,29942,44404,45609,52742,11421,13563,27040,16196,46831,61416,56280,56385,54969,18628,3560,38771,22868,63318,30827,32509,34615,22777,3973,23551,50640,63200,21105,1408,16144,60970,26057,61624,50476,39125,49742,44235,50423,12835,58181,602,27710,63713,567,32400,63679,22389,50387,53312,28490,54426,7525,43421,40312,30515,40763,34329,43364,22464,6882,49814,61288,15066,19531,55647,12120,61858,21988,26778,40624,30544,13472,38658,62810,52198,2040,48028,32727,13663,2511,58555,30299,36413,43268,22780,24902,62321,400,22255,42935,35723,10225,4398,4266,22212,26020,51597,62176,41268,25425,33387,17557,30806,60702,53231,27923,53789,5906,63830,31516,33122,6626,57332,35366,61832,11517,16167,29425,8107,3764,47001,35149,37473,32555,20302,60469,16127,47679,45150,2241,64850,51702,2886,13022,5531,746,53740,12685,48694,58919,65066,50016,7214,58719,21780,26581,43067,46275,35817,18728,25198,12621,36689,21875,14187,35134,4119,21858,21045,2038,14609,18325,57692,38219,46309,32176,22335,7355,19657,53263,17281,33552,49989,36959,28332,19114,34465,5644,38625,7587,22413,2447,10775,29130,45876,48549,8596,38252,50473,57699,60200,18800,1334,28308,14843,56733,55412,37684,65213,58580,45544,54584,30055,58322,55737,54502,58013,49931,2979,41336,44549,59273,5049,49019,33080,27306,27210,1154,50882,63458,22919,15695,55092,29681,19506,19473,45243,58400,25444,55208,24393,24079,54484,29733,23397,6085,27709,37915,40917,32517,57638,25379,1617,12204,17219,41820,38446,55399,5526,34515,59398,36532,46499,44229,50755,51698,9605,7948,28365,52985,63928,55202,5901,36567,50346,15054,23109,2199,56067,52360,50713,56424,50673,20542,6931,43663,8641,26533,52633,11694,44973,60025,36505,21881,11021,51778,43596,18530,62013,17084,2492,53958,60531,46520,42469,19110,37533,18301,47488,22494,62414,44084,22320,47553,21885,41500,19272,50663,6977,18020,16637,4169,36133,15555,22142,65364,46534,20705,56982,50837,58176,20159,61974,5394,14109,13805,9882,3695,62580,46533,49180,63839,57254,49464,48251,27312,42170,5086,29751,29398,4279,4754,47105,12929,55726,24196,18254,33438,49836,36578,41934,28118,31667,536,33126,33214,22013,7752,38045,14595,59419,27634,48316,26492,46819,59988,29634,3321,6608,22429,58174,17889,4615,4034,64364,12270,33776,38091,51517,52787,3991,22014,38746,6617,10308,34202,64311,17274,19524,34443,27232,53192,44277,18592,54831,32643,37760,28248,22866,41177,54400,19967,42887,31205,57319,59682,50838,38333,2286,60566,61426,21373,63861,33626,21866,13062,50534,52718,63942,20711,61390,63967,20829,20841,11701,49152,51635,31678,45050,27513,55729,57780,20799,65250,28593,6903,29248,6,55697,6278,64167,35808,56203,20323,50185,31243,4501,12719,55915,8733,59204,30373,57505,60723,76,28559,31275,3678,37859,19250,2503,55490,9005,6798,4032,16058,48836,46715,31110,41926,42976,22897,22631,23825,17598,10883,44373,8417,26406,4947,29621,64666,48875,36561,9577,25441,32701,5224,4994,7369,35258,64801,37199,14584,24179,57310,42634,33997,10441,17730,33754,55513,3928,60111,18903,13657,19417,43033,13349,56010,4049,44561,38012,22702,49047,890,29183,31734,30273,31929,42640,56762,9163,15011,26371,28398,63493,53005,45833,53975,1747,23461,17934,15258,56168,42894,63270,39113,10517,25999,28931,8278,1109,6443,20858,37697,23393,61488,14881,59776,61577,13424,20183,20166,21017,39526,14363,32700,27492,5718,29303,25594,11740,57474,11624,42227,38160,55136,54975,11286,29907,3916,62127,18420,39858,50950,56379,2066,43205,49566,53860,9820,7851,14174,18348,1093,37987,59571,54198,27222,5515,11974,38225,2278,2388,47867,12095,25705,35978,25242,1422,9183,40646,44067,29195,42869,31371,58168,60967,14662,55894,60998,39821,48403,47377,64549,40903,7687,16004,12849,16035,10198,9672,44003,34644,52073,36533,41448,61024,12009,63541,10901,16430,5739,45759,48450,4490,25030,28852,5132,47091,53088,24040,49877,61468,62645,2677,38110,50538,5323,50467,45935,41341,465,63752,59854,36689,24911,33904,32020,13809,46166,48075,13391,7973,32323,47940,14150,41352,6275,7463,39384,2869,23363,49479,18868,14754,51715,8121,47579,39780,13541,987,52648,38161,34622,36503,30262,38213,44455,12376,1388,46593,31486,15609,5747,23879,50249,14524,58282,30730,28061,7716,34814,176,57205,31614,42617,21180,20148,36943,29613,59619,39255,2852,26018,55662,30871,32281,21641,55285,17690,9465,58626,19225,20873,4253,58234,50586,43733,3307,62515,37709,940,31931,39038,60683,56258,25912,50862,39419,64434,64996,59703,61479,24846,28640,14511,43202,21208,18183,8278,20630,62212,25648,8770,65168,4447,53429,33066,31909,56275,10469,56775,38608,9063,14035,51824,5997,32508,11159,6829,10928,5378,44831,30863,31492,60363,51588,29836,24983,13109,23308,34892,64370,12431,24075,1098,27611,64636,10291,3137,52714,20883,56049,15149,67,20314,3081,993,30045,59633,48055,13483,6488,6483,17868,8160,30834,54669,45269,1507,18261,20691,65143,31214,63167,43681,44620,25074,56647,53563,17492,19813,51985,45225,23410,38688,30111,62248,45712,2590,60090,41924,31773,29265,42788,58537,10393,65137,49107,35986,14397,2886,22710,49522,12845,61060,62781,42130,23255,57515,19557,61472,17088,5054,6579,46082,40477,61789,61639,10758,17350,25115,1170,31495,13170,52962,4019,35498,12982,3204,40775,64750,49629,56005,62036,8993,45543,53482,44673,60563,44395,36225,169,44900,55801,5370,44214,55747,559,27779,16541,38527,29348,21026,34949,62683,51207,61416,9642,42412,9175,1476,54245,57055,44692,63142,11216,2750,4315,7761,61553,61014,64330,49392,13825,28869,13478,57482,58826,27337,44896,45511,8624,39388,17213,40259,21776,43367,8723,38271,3029,36090,62903,50100,33424,36725,41311,45957,62691,15425,31580,42540,34996,54461,64796,48095,40915,39550}));
    }

    public static boolean xorGame(int[] nums) {
        List<Integer> leftList = new ArrayList<>();
        for (int i : nums) {
            leftList.add(i);
        }

        //汇总所有位的总和
        int[] bits = getBits(nums);

        //模拟玩游戏
        int i = 1;
        for (; i <= nums.length; i++) {
            if (finish(bits)) {
                break;
            }

            Integer bestChoose = findBestChoose(leftList, bits);
            leftList.remove(bestChoose);
            reduceBestChoose(bestChoose, bits);
        }

        //判断游戏结束时是否为Alice
        return i % 2 != 0;
    }


    public static int[] getBits(int[] nums) {
        int[] bits = new int[31];
        for (int i = 0; i < bits.length; i++) {
            int count = 0;
            for (int num : nums) {
                count += 1 & (num >> i);
            }
            bits[i] = count;
        }
        return bits;
    }

    //减去哪个数能让bits中奇数最多，这个数就是当前步骤最优解
    public static Integer findBestChoose(List<Integer> leftList, int[] bits) {
        int bestChoose = leftList.get(0), bestEffectBitCount = 0;
        for (int num : leftList) {
            int thisNumEffectBitCount = 0;
            for (int i = 0; i < bits.length; i++) {
                if ((bits[i] - (1 & (num >> i))) % 2 == 1) {
                    thisNumEffectBitCount++;
                }
            }

            if (thisNumEffectBitCount > bestEffectBitCount) {
                bestEffectBitCount = thisNumEffectBitCount;
                bestChoose = num;
            }
        }
        return bestChoose;
    }

    public static void reduceBestChoose(int bestChoose, int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = bits[i] - (1 & (bestChoose >> i));
        }
    }


    public static boolean finish(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }





    public boolean xorGame2(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }

}