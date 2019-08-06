package leetcode.easy;

/**
 * Created by Mr.Wang on 2019/8/5.
 */
public class DefangIPaddr {
    public static String defangIPaddr(String address) {
        int pointCount = 0;
        char[] addrChars = address.toCharArray();
        for(char c : addrChars){
            if('.'==c){
                pointCount++;
            }
        }
        if(pointCount == 0){
            return address;
        }

        char[] resultChars = new char[addrChars.length + 2*pointCount];
        int j = resultChars.length-1;
        for(int i = addrChars.length - 1; i >= 0; i--){
            if(addrChars[i] != '.'){
                resultChars[j--] = addrChars[i];
            }else{
                resultChars[j--] = ']';
                resultChars[j--] = '.';
                resultChars[j--] = '[';
            }
        }
        return new String(resultChars);
        //return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
}
