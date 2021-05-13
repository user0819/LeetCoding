package leetcode.easy;


import util.ArrayUtil;

/**
 * @author XIANG
 * @since 2020/11/13 9:19
 */
public class Sort {

    /**
     * 快速排序
     * 选择一个哨兵
     * 哨兵左边 < 哨兵 < 哨兵右边
     */
    public static void quickSort(int[] array) {
        int begin = 0, end = array.length - 1;
        quickSort(array, begin, end);
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int left = begin, right = end;
        while (left < right) {
            while (left < right && array[right] >= array[begin]) {
                right--;
            }
            while (left < right && array[left] <= array[begin]) {
                left++;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        int temp = array[begin];
        array[begin] = array[right];
        array[right] = temp;

        quickSort(array, begin, right);
        quickSort(array, right + 1, end);
    }

    /**
     * 归并排序
     * 左边有序、右边有序
     * 合并两个有序数据
     */
    public static void mergeSort(int[] array) {
        int begin = 0, end = array.length - 1;

        int[] temp = new int[array.length];  //每次合并两个顺序数组的时候，都使用temp数组，避免额外开辟空间
        mergeSort(array, begin, end, temp);
    }

    private static void mergeSort(int[] array, int begin, int end, int[] temp) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(array, begin, mid, temp);
        mergeSort(array, mid + 1, end, temp);

        mergeTwoArray(array, begin, end, temp);

    }

    private static void mergeTwoArray(int[] array, int begin, int end, int[] temp ) {
        //int[] temp = new int[end - begin + 1];

        int mid = (begin + end) / 2;
        int index = begin, i = begin, j = mid + 1;
        while (i <= mid && j <= end) {
            if(array[i] < array[j]){
                temp[index++] = array[i++];
            }else{
                temp[index++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= end) {
            temp[index++] = array[j++];
        }

        for (int k = begin; k <= end ; k++) {
            array[k] = temp[k];
        }

    }

    /**
     * 冒泡排序
     * 两两比较、大的挪到后面
     */
    public static void BubbleSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 每次选择一个最大的，挪到后面
     */
    public static void chooseSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int maxIndex = 0;
            for (int j = 0; j <= length - i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = array[length - i];
            array[length - i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int j = i - 1;
            //找到要插入的位置j
            while (j >= 0 && array[j] > array[i]) {
                j--;
            }
            j += 1;
            int temp = array[i];
            //j后面的所有元素后移
            for (int k = i; k > j; k--) {
                array[k] = array[k - 1];
            }
            array[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 36, 1, 2, 3254, 236, 1535, 122, 23};
        mergeSort(array);
        ArrayUtil.print(array);
    }
}
