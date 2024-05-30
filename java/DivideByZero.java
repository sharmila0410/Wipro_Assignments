import java.util.*;

public class DivideByZero{

    public static void main(String[]args){

        Scanner s = new Scanner(System.in);

        System.out.println("enter the first number:");
        int a = s.nextInt();

        System.out.println("enter the second number:");
        int b = s.nextInt();

        try{
            int result = division(a, b);
            System.out.println("result:"+result);
        }catch(ArithmeticException e){
            System.out.println("invalid:division by zero is not allowed");
        }

    }
    public static int division(int a, int b){
        if(b == 0){
            throw new ArithmeticException("division by zero");
        }
        return a/b;
    }
}