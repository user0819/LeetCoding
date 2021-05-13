package sort;

/**
 * @author XIANG
 * @since 2020/3/17 12:46
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr= new int[]{5,89,12,656,41,2,667,44444,155555,12,1};
        quickSort(arr,0,arr.length-1);
        for (int i: arr) {
            System.out.print(i +"、");

        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int base =arr[start];
        int i=start,j=end;
        while(i!=j){

            while(arr[j] >= base && i<j){
                j--;
            }
            while(arr[i]<=base && i<j){
                i++;
            }
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] =tmp;
        }
        int tmp = arr[i];
        arr[i] = arr[start];
        arr[start] =tmp;

        quickSort(arr, start, i-1);
        quickSort(arr,i+1,end);
    }
}
