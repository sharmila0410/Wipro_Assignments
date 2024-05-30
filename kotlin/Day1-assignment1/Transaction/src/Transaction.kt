import java.text.SimpleDateFormat
import java.util.*

class Transaction(val amount: Double, val date: Date, val category: String)
fun main(){
    val scanner = Scanner(System.`in`)

    print("enter amount:")
    val amount = scanner.nextDouble()

    print("enter date(yyyy-mm-dd): ")
    val dateString = scanner.next()
    val dateFormat = SimpleDateFormat("yyyy-mm-dd")
    val date = dateFormat.parse(dateString)

    print("enter category: ")
    val category = scanner.next()

    val transaction = Transaction(amount, date, category)

    println("transaction details:")
    println("Amount:${transaction.amount}")
    println("Date:${dateFormat.format(transaction.date)}")
    println("Category:${transaction.category}")
}