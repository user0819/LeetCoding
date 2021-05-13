package leetcode.easy;

/**
 * @author XIANG
 * @since 2020/10/19 13:09
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    private String getString(String S) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i< S.length(); i++){
            if(S.charAt(i) != '#'){
                stringBuilder.append(S.charAt(i));
            }else{
                if(stringBuilder.length() > 0){
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }
}
