public class Calculator {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Calculator <operation> <operand1> <operand2>");
            return;
        }

        String operation = args[0];
        double operand1 = Double.parseDouble(args[1]);
        double operand2 = Double.parseDouble(args[2]);
        double result = 0;

        switch (operation) {
            case "add":
                result = operand1 + operand2;
                break;
            case "subtract":
                result = operand1 - operand2;
                break;
            case "multiply":
                result = operand1 * operand2;
                break;
            case "divide":
                if (operand2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                result = operand1 / operand2;
                break;
            default:
                System.out.println("Invalid operation. Supported operations: add, subtract, multiply, divide.");
                return;
        }

        System.out.println("Result: " + result);
    }
}

/*In this java program a simple calculator is performed using command-line arguments. 
Command-line arguments is nothing but passing the values at the time of running the java program.
 * it then checks for number if arguments, if it is less than 3 it says invalid input and exits.
 * if it has enough arguments, it continues.
 * here, the operatoin is stored in a string variable which is then parsed into double method and stores them in operands.
 * it then performs operation which is given as switch statements where the desired arithmetic operation is perrformed.
 * for example, if it is addition it perform "add" operations and add operands 1 and 2.
 * it throws error when try to divide by zero which leads to arithmetic exception.
 * as a result, the output is printed according to the user outputs.
 */