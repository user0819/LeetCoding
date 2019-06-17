package leetcode;

import java.util.Arrays;

/**
 * Created by Mr.Wang on 2019/6/13.
 */
public class SortedSquaresClass {
    public static int[] sortedSquares(int[] A) {
        int start  = 0;                         //标记正数开始位
        for(int i =0 ;i<A.length; i++){
            if(A[i] >= 0){
                start = i;
                break;
            }
        }

        int[] B = new int[A.length];
        int i = start, j = start - 1, index = 0;

        while(i < A.length && j > 0){
            int a = A[i]*A[i];
            int b = A[j]*A[j];

            if(a<=b){
                B[index] = a;
                i++;
            }else{
                B[index] = b;
                j++;
            }
            index++;
        }
        while(i < A.length){
            B[index++] = A[i]*A[i];
            i++;
        }
        while(j > 0){
            B[index++] = A[j]*A[j];
            j++;
        }
        return B;

    }

    public static int[] sortedSquares2(int[] A) {
         for(int i = 0 ; i < A.length; i++){
             A[i]  = A[i] * A[i];
         }
         Arrays.sort(A);
         return A;
    }

    public static void main(String[] args) {
        sortedSquares(new int[]{-4,-1,0,3,10});
    }

}
