package util;

/**
 * @author XIANG
 * @since 2020/11/13 16:04
 */
public class ArrayUtil {
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static void print(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ":" + array[i]);
        }
    }
}
