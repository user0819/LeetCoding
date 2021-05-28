package leetcode.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
 * I 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 * 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * <p>
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num <= 3999
 *
 * @author XIANG
 * @since 2021/2/3 9:36
 */
public class IntToRoman {
    /**
     * * 字符          数值
     * * I             1
     * * V             5
     * * X             10
     * * L             50
     * * C             100
     * * D             500
     * * M             1000
     * *
     */
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println(intToRomanV2(1994));
        System.out.println(intToRomanV3(1994));
    }

    public static String intToRoman(int num) {
        if (num > 3999) {
            return "";
        }
        Map<Integer, String> int2RomanMap = new HashMap<>();
        int2RomanMap.put(0, "");
        int2RomanMap.put(1, "I");
        int2RomanMap.put(2, "II");
        int2RomanMap.put(3, "III");
        int2RomanMap.put(4, "IV");
        int2RomanMap.put(5, "V");
        int2RomanMap.put(6, "VI");
        int2RomanMap.put(7, "VII");
        int2RomanMap.put(8, "VIII");
        int2RomanMap.put(9, "IX");
        int2RomanMap.put(10, "X");
        int2RomanMap.put(20, "XX");
        int2RomanMap.put(30, "XXX");
        int2RomanMap.put(40, "XL");
        int2RomanMap.put(50, "L");
        int2RomanMap.put(60, "LX");
        int2RomanMap.put(70, "LXX");
        int2RomanMap.put(80, "LXXX");
        int2RomanMap.put(90, "XC");
        int2RomanMap.put(100, "C");
        int2RomanMap.put(200, "CC");
        int2RomanMap.put(300, "CCC");
        int2RomanMap.put(400, "CD");
        int2RomanMap.put(500, "D");
        int2RomanMap.put(600, "DC");
        int2RomanMap.put(700, "DCC");
        int2RomanMap.put(800, "DCCC");
        int2RomanMap.put(900, "CM");
        int2RomanMap.put(1000, "M");

        StringBuilder stringBuilder = new StringBuilder();
        int thousandMod = num / 1000;
        for (int i = 0; i < thousandMod; i++) {
            stringBuilder.append(int2RomanMap.get(1000));
        }
        num %= 1000;
        int hundredBit = num / 100 * 100;
        stringBuilder.append(int2RomanMap.get(hundredBit));
        num %= 100;
        int tenBit = num / 10 * 10;
        stringBuilder.append(int2RomanMap.get(tenBit));
        num %= 10;
        int bit = num;
        stringBuilder.append(int2RomanMap.get(bit));

        return stringBuilder.toString();
    }

    public static String intToRomanV2(int num) {
        if (num > 3999) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        //千位
        int thousandBit = num / 1000;
        num %= 1000;
        for (int i = 0; i < thousandBit; i++) {
            sb.append('M');
        }

        //百位
        int hundredBit = num / 100;
        num %= 100;

        if (hundredBit == 9) {
            sb.append("CM");
            hundredBit = 0;
        }

        if (hundredBit >= 5) {
            sb.append("D");
            hundredBit %= 5;
        }

        if (hundredBit == 4) {
            sb.append("CD");
            hundredBit = 0;
        }
        for (int i = 0; i < hundredBit; i++) {
            sb.append('C');
        }


        //十位
        int tenBit = num / 10;
        num %= 10;
        if (tenBit == 9) {
            sb.append("XC");
            tenBit = 0;
        }
        if (tenBit >= 5) {
            sb.append("L");
            tenBit %= 5;
        }
        if (tenBit == 4) {
            sb.append("XL");
            tenBit = 0;
        }
        for (int i = 0; i < tenBit; i++) {
            sb.append('X');
        }


        //个位
        int singleBit = num;

        if (singleBit == 9) {
            sb.append("IX");
            singleBit = 0;
        }

        if (singleBit >= 5) {
            sb.append("V");
            singleBit %= 5;
        }

        if (singleBit == 4) {
            sb.append("IV");
            singleBit = 0;
        }
        for (int i = 0; i < singleBit; i++) {
            sb.append('I');
        }

        return sb.toString();
    }


    public static String intToRomanV3(int num) {
        if (num > 3999) {
            return "";
        }
        Map<Integer, String[]> map = new HashMap<>();
        map.put(1, new String[]{"IX", "V", "IV", "I"});
        map.put(10, new String[]{"XC", "L", "XL", "X"});
        map.put(100, new String[]{"CM", "D", "CD", "C"});
        map.put(1000, new String[]{"", "", "", "M"});

        StringBuilder sb = new StringBuilder();
        int subValue = 1000;
        while (num != 0) {
            int thisBit = num / subValue;
            if (thisBit == 9) {
                sb.append(map.get(subValue)[0]);
                thisBit = 0;
            }
            if (thisBit >= 5) {
                sb.append(map.get(subValue)[1]);
                thisBit %= 5;
            }
            if (thisBit == 4) {
                sb.append(map.get(subValue)[2]);
                thisBit = 0;
            }
            for (int i = 0; i < thisBit; i++) {
                sb.append(map.get(subValue)[3]);
            }
            num %= subValue;
            subValue /= 10;
        }

        return sb.toString();
    }


    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRomanV4(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }


    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRomanV5(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
