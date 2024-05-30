public class LinerSearch{

    public static void main(String[]args){

        int arr[] = {5,3,2,7,8,9};
        int target = 7;

        int index = PerformLinearSearch(arr, target);

        if(index != -1){
            System.out.println("element found at:"+index);
        }else{
            System.out.println("element not found");
        }
    }

    public static int PerformLinearSearch(int arr[], int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Element found, return its index
            }
        }
        return -1;
    }
}