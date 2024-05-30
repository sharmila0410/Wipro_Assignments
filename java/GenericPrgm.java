import java.util.*;
public class GenericPrgm {
    public static<T> void swap(T[]arr, int i, int j){
        if(i >= 0 && i< arr.length && j>= 0 && j<arr.length){
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public static void main(String[]args){
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"hello", "hi", "welcome", "good"};

        swap(intArray, 0, 2);
        System.out.println("swapped intArray:"+Arrays.toString(intArray));

        swap(stringArray, 1, 2);
        System.out.println("swapped stringArray:"+Arrays.toString(stringArray));
    }
    
}
