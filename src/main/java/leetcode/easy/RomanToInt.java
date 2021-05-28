package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XIANG
 * @since 2020/4/21 12:51
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("IM"));
        System.out.println(romanToInt2("IM"));
        System.out.println(romanToInt3("IM"));
    }

    // 方法一：枚举法，枚举当前位置的每一种可能，加上对应的值
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        result += 4;
                        i--;
                    } else {
                        result += 5;
                    }
                    break;
                case 'X':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        result += 9;
                        i--;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        result += 40;
                        i--;
                    } else {
                        result += 50;
                    }
                    break;
                case 'C':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        result += 90;
                        i--;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        result += 400;
                        i--;
                    } else {
                        result += 500;
                    }
                    break;
                case 'M':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        result += 900;
                        i--;
                    } else {
                        result += 1000;
                    }
                    break;
            }
        }
        return result;
    }

    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }


    /**
     *  将对应的值都放在map中，
     *  每次优先拿两位罗马数获取对应值，获取到对应值则直接累加
     *  获取不到对应值，则尝试只根据当前一位再获取值
     */
    public static int romanToInt2(String s) {
        int sum = 0;
        int length = s.length();
        for (int i = 0; i < length; ) {
            if (i < length - 1 && map.get(s.substring(i, i + 2)) != null) {
                sum += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                sum += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }


    private static Map<Character, Integer> map2 = new HashMap<>();

    static {
        map2.put('I', 1);
        map2.put('V', 5);
        map2.put('X', 10);
        map2.put('L', 50);
        map2.put('C', 100);
        map2.put('D', 500);
        map2.put('M', 1000);
    }

    /**
     *  将对应的值都放在map中，
     *  每次只获取当前一位值
     *  利用罗马数的一个特点：
     *  当前位的值 < 后一位的值 时，需要减去当前位的值.
     *  类似CMXCIV这种
     *  注意:罗马数的特点能保证永远不会出现 IMXM 这样的数
     */
    public static int romanToInt3(String s) {
        int sum = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int value = map2.get(s.charAt(i));
            if (i < length - 1 && map2.get(s.charAt(i + 1)) > value) {
                sum -= value;
            } else {
                sum += value;
            }
        }
        return sum;
    }
}
