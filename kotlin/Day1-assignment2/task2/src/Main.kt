import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter your name: ")
    val name = scanner.nextLine()

    print("Enter your age: ")
    val age = scanner.nextInt()

    scanner.nextLine()

    val welcomeMessage = "Welcome, $name! You are $age years old."

    println(welcomeMessage)
}