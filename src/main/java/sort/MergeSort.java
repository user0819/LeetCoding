package sort;

/**
 * @author wangxiang
 * @since 2020/3/19 12:46
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr= new int[]{5,89,12,656,41,2,667,44444,155555,12,1};
        mergeSort(arr,0,arr.length-1);
        for (int i: arr) {
            System.out.print(i +"、");

        }
    }

    public static void mergeSort(int[] arr, int start, int end){
        System.out.println(start+": "+end);
        if(start < end){
            int mid = (start+end)/2;
            mergeSort(arr, start,mid);
            mergeSort(arr,mid+1,end);

            int[] temp =new int[end-start+1];
            int i=start,j=mid+1,count=0;

            while(i<=mid&& j<=end){
                if(arr[i]>arr[j]){
                    temp[count++] =arr[j++];
                }else{
                    temp[count++] =arr[i++];
                }
            }
            while(i<=mid){
                temp[count++] =arr[i++];
            }
            while(j<=end){
                temp[count++] =arr[j++];
            }

            //将temp中的元素全部拷贝到原数组中
            count=0;
            while(start <= end){
                arr[start++] = temp[count++];
            }
        }

    }
}
