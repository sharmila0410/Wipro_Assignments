class User(val username: String, private var password: String) {

    // Simplistic login method (improve for real applications)
    fun login(attempt: String): Boolean {
        return attempt == password
    }

    // Data class for transactions (replace with your actual data structure)
    data class Transaction(val date: Long, val amount: Double)

    // List to hold transactions
    private val transactions = mutableListOf<Transaction>()

    // Add a transaction
    fun addTransaction(date: Long, amount: Double) {
        transactions.add(Transaction(date, amount))
        println("Transaction added successfully.")
    }

    // Filter and sort transactions by date (lambda expression and higher-order function)
    fun filterAndSortTransactionsByDate(from: Long, to: Long, ascending: Boolean = true): List<Transaction> {
        return transactions.filter { it.date in from..to }
            .sortedBy { it.date }
            .let { if (!ascending) it.reversed() else it }
    }

    // Sort transactions by amount (higher-order function)
    fun sortTransactionsByAmount(ascending: Boolean = true): List<Transaction> {
        return transactions.sortedBy { it.amount }
            .let { if (!ascending) it.reversed() else it }
    }

    // Display summary of expenses (basic formatting)
    fun displayExpenseSummary() {
        if (transactions.isEmpty()) {
            println("No transactions recorded yet.")
        } else {
            val total = transactions.sumByDouble { it.amount }
            val average = total / transactions.size
            println("Total Expenses: $total")
            println("Average Expense: $average")
        }
    }
}

fun main() {
    // Create a user
    val user = User("user1", "password")

    // Add some transactions
    user.addTransaction(1621234567890, 100.0)
    user.addTransaction(1622345678901, 50.0)
    user.addTransaction(1623456789012, 80.0)

    // Filter and sort transactions by date
    println("\nFiltering and sorting transactions by date (ascending):")
    val filteredAndSortedTransactions = user.filterAndSortTransactionsByDate(1620000000000, 1623000000000)
    filteredAndSortedTransactions.forEach { println(it) }

    // Sort transactions by amount
    println("\nSorting transactions by amount (descending):")
    val sortedTransactionsByAmount = user.sortTransactionsByAmount(false)
    sortedTransactionsByAmount.forEach { println(it) }
}