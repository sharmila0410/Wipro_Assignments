import java.util.*;
public class SumArray{
    public static void main(String[]args){

        Scanner s = new Scanner(System.in);
        System.out.println("enter array size:");
        int n = s.nextInt();

        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }

        int sum = sumArray(arr);
        System.out.println("enter sum of arrays:"+sum);

        s.close();
    }

    public static int sumArray(int arr[]){
        return sumArrayRecursive(arr, 0);
    }

    private static int sumArrayRecursive(int arr[], int index){
        if(index == arr.length){
            return 0;
        }
        return arr[index] + sumArrayRecursive(arr, index+1);
    }
}
