package leetcode;

/**
 * @author wangxiang
 * @since 2020/3/28 13:03
 */
public class ZConvert {
    public static void main(String[] args) {
        //System.out.println((int)Math.ceil((double)1/3));
        System.out.println(convert("A", 1));
    }

    /**
     * Z自行字符串翻转
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1 ){return s;}
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        int size = numRows + numRows - 2;
        int num = (int) Math.ceil((double) len / size);
        int t1,t2;
//        System.out.println(num);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < num; j++) {
                t1 = i + j * size;
                if (t1 < len) {
                    stringBuilder.append(s.charAt(t1));
                    if (i != 0 && i != numRows - 1) {
                        t2 = (j*2 + 1) * size - t1;
                        if (t2 < len) {
                            stringBuilder.append(s.charAt(t2));
                        }
                    }
                }

            }
        }

        return stringBuilder.toString();
    }
}
