import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = s.nextInt();

       boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        s.close();
    }
}