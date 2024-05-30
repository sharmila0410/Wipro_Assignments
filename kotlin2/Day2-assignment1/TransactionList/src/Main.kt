import java.util.*

data class Transaction(val id: Int, var amount: Double, var date: Date, var category: String)

class TransactionList {
    private val transactions = mutableListOf<Transaction>()
    private var nextId = 1

    fun addTransaction(amount: Double, date: Date, category: String) {
        val transaction = Transaction(nextId++, amount, date, category)
        transactions.add(transaction)
        println("Transaction added successfully.")
    }

    fun deleteTransaction(id: Int) {
        val transaction = transactions.find { it.id == id }
        if (transaction != null) {
            transactions.remove(transaction)
            println("Transaction deleted successfully.")
        } else {
            println("Transaction with ID $id not found.")
        }
    }

    fun editTransaction(id: Int, amount: Double? = null, date: Date? = null, category: String? = null) {
        val transaction = transactions.find { it.id == id }
        if (transaction != null) {
            if (amount != null) {
                transaction.amount = amount
            }
            if (date != null) {
                transaction.date = date
            }
            if (category != null) {
                transaction.category = category
            }
            println("Transaction edited successfully.")
        } else {
            println("Transaction with ID $id not found.")
        }
    }

    fun printTransactions() {
        println("\nTransactions:")
        transactions.forEach { println(it) }
    }
}

fun main() {
    val transactionList = TransactionList()
    val scanner = Scanner(System.`in`)

    var choice: Int
    do {
        println("\nTransaction Management System")
        println("1. Add Transaction")
        println("2. Delete Transaction")
        println("3. Edit Transaction")
        println("4. Print Transactions")
        println("5. Exit")
        print("Enter your choice: ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                print("Enter amount: ")
                val amount = scanner.nextDouble()

                print("Enter date (yyyy-MM-dd): ")
                val dateString = scanner.next()
                val dateFormat = java.text.SimpleDateFormat("yyyy-MM-dd")
                val date = dateFormat.parse(dateString)

                print("Enter category: ")
                val category = scanner.next()

                transactionList.addTransaction(amount, date, category)
            }
            2 -> {
                print("Enter ID of transaction to delete: ")
                val id = scanner.nextInt()
                transactionList.deleteTransaction(id)
            }
            3 -> {
                print("Enter ID of transaction to edit: ")
                val id = scanner.nextInt()

                println("Enter new amount (leave blank to keep current): ")
                val newAmount = scanner.nextDoubleOrNull()

                println("Enter new date (yyyy-MM-dd) (leave blank to keep current): ")
                val newDateString = scanner.nextLine().takeIf { it.isNotBlank() } ?: scanner.next()
                val dateFormat = java.text.SimpleDateFormat("yyyy-MM-dd")
                val newDate = newDateString.takeIf { it.isNotBlank() }?.let { dateFormat.parse(it) }

                println("Enter new category (leave blank to keep current): ")
                val newCategory = scanner.nextLine().takeIf { it.isNotBlank() } ?: scanner.next()

                transactionList.editTransaction(id, newAmount, newDate, newCategory)
            }
            4 -> transactionList.printTransactions()
            5 -> println("Exiting...")
            else -> println("Invalid choice. Please try again.")
        }
    } while (choice != 5)
}

fun Scanner.nextDoubleOrNull(): Double? {
    return if (hasNextDouble()) nextDouble() else null
}