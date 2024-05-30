import java.util.Arrays;
import java.util.Scanner;

public class BruteForce{

    public static void main(String[]args){

        Scanner s = new Scanner(System.in);

        System.out.println("enter array size:");
        int n = s.nextInt();

        System.out.println("enter array elements:");
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }

        System.out.println("original array");
        System.out.println(Arrays.toString(arr));

        BruteForceSort(arr);

        System.out.println("enter sorted array:");
        System.out.println(Arrays.toString(arr));

        s.close();
    }

    public static void BruteForceSort(int arr[]){

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if current element is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
