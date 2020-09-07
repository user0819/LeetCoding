package leetcode.easy;

/**
 * @author wangxiang
 * @since 2020/9/1 11:20
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("111","0011"));
    }

    public static String addBinary(String a, String b) {
        Integer intA = Integer.parseInt(a, 2);
        Integer intB = Integer.parseInt(b, 2);
        Integer sum = intA + intB;
        return Integer.toString(sum,2);
    }
}
