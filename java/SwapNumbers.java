import java.util.*;

public class SwapNumbers {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int b = scanner.nextInt();

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping:");
        System.out.println("First integer: " + a);
        System.out.println("Second integer: " + b);

        scanner.close();
    }
}
/*In the above program i have declared two varriable with user defined values.
 * and here am doing swapping of two numbers without using third variable
 * and this can be done using x-or methods or simple arithmetic operations.
 * then i printed the swapped two variables.
 */
