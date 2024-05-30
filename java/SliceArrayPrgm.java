import java.util.Arrays;

public class SliceArrayPrgm{

    public static void main(String[]args){

        int arr[] = {3,2,1,5,4,6,7,8,9};
        int start = 3;
        int end = 6;

        int slicedArray[] = sliceArray(arr, start, end);
        System.out.println("original array:"+Arrays.toString(arr));
        System.out.println("sliced array:"+Arrays.toString(slicedArray));
    }
        public static int[] sliceArray(int arr[], int start, int end){
            if(start < 0 || end >= arr.length || start > end){
                throw new IllegalArgumentException("invlid start or end index");
            }
            int slicedArray[] = new int[end - start + 1];
            for(int i = start, j = 0; i <= end; i++, j++){
                slicedArray[j] = arr[i];
            }
            return slicedArray; 
        }
    
}