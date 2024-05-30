import java.util.*;

public class ReverseArray {

    public static void main(String[]args){

        Scanner s = new Scanner(System.in);

        System.out.println("enter the size of array:");
        int n = s.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        System.out.println("array elements:");
        printArray(arr);

        System.out.println("reversed array:");
        printReverseArray(arr);

        s.close();

    }

    public static void printArray(int arr[]){
        for(int i:arr){
            System.out.println(i+" ");
        }
    }

    public static void printReverseArray(int arr[]){
        for(int i = arr.length-1; i >= 0; i--){
            System.out.println(arr[i]+" ");
        }
    }
    
}
