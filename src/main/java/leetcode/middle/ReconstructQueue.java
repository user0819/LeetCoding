package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Mr.Wang on 2019/7/15.
 */
public class ReconstructQueue {

    public static int[][] reconstructQueue(int[][] people) {
        if(people.length == 0){
            return people;
        }

        //排序结果：7.0、7.1、6.1、5.0...
        Arrays.sort(people, (o1, o2) ->{
                if((o1[0] > o2[0]) || (o1[0] == o2[0] && o1[1] < o2[1])  ){
                    return 1;
                }else if( o1[0] == o2[0] && o1[1] == o2[1] ){
                    return 0;
                }else{
                    return -1;
                }
            }
        );

        int moveIndex, count, j;
        int[][] result = new int[people.length][people[0].length];
        result[0] = people[people.length-1];

        for(int i = people.length - 2; i >= 0; i--){
            moveIndex = 0;
            count = 0;
            for(j = 0; j < result.length; j++){
                if(result[j][0] >= people[i][0] && ++count == people[i][1]){
                    moveIndex = j + 1;
                    break;
                }
            }
            moveBit(result,moveIndex);
            result[moveIndex] = people[i];
        }
        return result;

    }

    public static void moveBit(int [][] arrays, int num){
        for (int i =  arrays.length -1 ; i > num ; i--) {
            arrays[i] = arrays[i-1];
        }
    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
    }
}
