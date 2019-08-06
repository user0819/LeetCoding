package leetcode.easy;

import java.util.Arrays;

/**
 * Created by Mr.Wang on 2019/4/3.
 */
public class QuickSort {
    public static void sort(int[] array,int start,int end){
        if(start>=end){
            return;
        }

        int i = start, j = end;
        int mid = array[i];
        while(i!=j){
            while (array[j]>=mid && i < j){
                j--;
            }
            while (array[i]<=mid && i < j){
                i++;
            }
            //交换大于基点和小于基点的数
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        //将基点放于中间位置
        int temp = array[i];
        array[i] = array[start];
        array[start] = temp;

        //递归排序左右数组
        sort(array,start,i);
        sort(array,i+1,end);
    }


    public static void quickSort(int[] arrays, int start, int end){
        if(start>=end){
            return;
        }

        int i = start;
        int j = end;
        int base  = arrays[start];

        while(i != j){
            while(arrays[j]>=base && i < j){
                j--;
            }
            while(arrays[i]<=base && i < j){          //如果i先走，而不是j先走，则i处的数会比哨兵大
                i++;
            }
            int temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
        }

        int temp = arrays[start];
        arrays[start] = arrays[i];
        arrays[i] = temp;
        quickSort(arrays,i+1,end);
        quickSort(arrays,start,j);

    }


    public static void quickSort3(int[] data, int start, int end){
        if(start>=end){
            return;
        }

        int i = start;
        int j = end;
        int base = data[i];

        while(i!=j){
            while (data[j]>=base && j > i){
                j--;
            }
            while (data[i] <= base && i < j){
                i++;
            }

            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        data[start] = data[i];
        data[i] = base;

        quickSort(data,start,i);
        quickSort(data,j+1,end);
    }



    public static void main(String[] args) {
        int[] data = new int[]{-1,25,656,2, 25,-25,45,12,78,2,6,89};
        quickSort3(data,0,data.length-1);
        //Arrays.stream(data).forEach(System.out::println);
    }
}
