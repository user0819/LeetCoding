package leetcode.easy;

/**
 * Created by Mr.Wang on 2019/6/13.
 */
public class HammingDistanceClass {
    public static int hammingDistance(int x, int y) {

        int a =  x^y;

        int count = 0;
        while(a!=0){
            if((a&1 )== 1){count++;}
            a = a>>1;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
