public class FibonacciArray {
    public static void main(String[]args){

        int n = 20;
        int fiboArray = new int[n];

        performFibonacciArray(fiboArray, n);

        System.out.println("First " + n + " Fibonacci elements: " + Arrays.toString(fiboArray));

        int nthElement = fibonacci(n);
        System.out.println("The " + n + "th Fibonacci element is: " + nthElement);
    }
    public static void performFibonacciArray(int arr[], int n){
        if(n >= 1){
            arr[0] = 0;
        }
        if(n >= 2){
            arr[1] = 1;
        }
        for(int i = 2; i < n; i++){
            arr[i] = fiboArray(i);
        }
    }
    public static int fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
        
    }
    
}
