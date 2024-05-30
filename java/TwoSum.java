import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum{

    public static void main(String[]args){
      
        int arr[] = {3,4,6,2,7,9};
        int target = 5;

        int result[] = PerformTwoSum(arr, target);

        if(result != null){
            System.out.println("indices of the two numbers:"+result[0]+","+result[1]);
        }else{
            System.out.println("not found at index");
        }
    }

    public static int[] PerformTwoSum(int arr[], int target){

       Map<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i < arr.length; i++){
        int complement = target - arr[i];
        if(map.containsKey(complement)){
            return new int[]{map.get(complement), i};
             }
            map.put(arr[i], i);
         }
        return null;
    }
}