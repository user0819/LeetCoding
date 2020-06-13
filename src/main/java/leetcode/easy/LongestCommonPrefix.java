package leetcode.easy;

/**
 * 最长子字符串
 * Simple
 *
 * @author wangxiang
 * @since 2020/4/28 12:46
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix3(new String[]{"abc","ab"}));
    }

    /**
     * 垂直查找
     * O(n*n)
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null ||strs.length == 0 ) {
            return "";
        }

        String firstStr = strs[0];
        for (int index = 0; index < firstStr.length(); index++) {
            char c = firstStr.charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length() || c != strs[i].charAt(index)) {
                    return firstStr.substring(0,index);
                }
            }
        }
        return firstStr;
    }


    /**
     * 水平查找
     * LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3​),…Sn)
     *  O(n*n)
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * 分治
     */
    public static String longestCommonPrefix3(String[] strs){
        if(strs == null ){
            return "";
        }
        return divideAndFind(strs,0, strs.length-1);
    }

    private static String divideAndFind(String[] strs, int l, int r){
        if(l==r){
            return strs[l];
        }

        int mid = (l+r)/2;
        String leftBest = divideAndFind(strs,l, mid);
        String rightBest = divideAndFind(strs, mid+1, r);

        return merge(leftBest, rightBest);
    }

    private static String merge(String left, String right){
        for (int i = 0; i < left.length(); i++) {
            if(i == right.length() || left.charAt(i)!=right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return left;
    }
}
