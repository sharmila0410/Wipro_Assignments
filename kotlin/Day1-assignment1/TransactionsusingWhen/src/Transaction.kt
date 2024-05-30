import java.util.*

class Transaction(val amount:Double, val date: Date, val category: String)
fun main(){

    val scanner = Scanner(System.`in`)

    val transaction = inputTransaction(scanner)
    categorizeTransaction(transaction)
}
fun inputTransaction(scanner: Scanner): Transaction{
    print("enter amount: ")
    val amount = scanner.nextDouble()

    print("enter date(yyyy-mm-dd): ")
    val dateString = scanner.next()
    val dateFormat = java.text.SimpleDateFormat("yyyy-mm-dd")
    val date = dateFormat.parse(dateString)

    print("enter category:")
    val category = scanner.next()

    return Transaction(amount, date, category)
}
fun categorizeTransaction(transaction: Transaction){
    val category = when(transaction.category) {
        "Groceries" -> "Food"
        "Utilities" -> "Utilities"
        "Entertainment" -> "Media"
        "savings" -> "Income"
        else -> "Other"
    }
    println("Transaction - Amount:${transaction.amount},Date:${transaction.date}, Category:${transaction.category}, Categorized as:$category")
}