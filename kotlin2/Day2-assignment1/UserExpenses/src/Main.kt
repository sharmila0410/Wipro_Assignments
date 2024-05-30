class User(val username: String, private var password: String) {
    private val expenses = mutableListOf<Double>()

    // Simplistic login method (improve for real applications)
    fun login(attempt: String): Boolean {
        return attempt == password
    }

    // Add an expense
    fun addExpense(amount: Double) {
        expenses.add(amount)
        println("Expense added successfully.")
    }

    // Display summary of expenses
    fun displayExpenseSummary() {
        if (expenses.isEmpty()) {
            println("No expenses recorded yet.")
        } else {
            val total = expenses.sum()
            val average = total / expenses.size
            val max = expenses.maxOrNull()
            val min = expenses.minOrNull()
            println("Total Expenses: $total")
            println("Average Expense: $average")
            println("Maximum Expense: $max")
            println("Minimum Expense: $min")
        }
    }
}

fun main() {
    // Create a user
    val user = User("user1", "password")

    // Login
    if (user.login("password")) {
        println("Login successful.")

        // Add expenses
        user.addExpense(50.0)
        user.addExpense(30.0)
        user.addExpense(20.0)

        // Display expense summary
        user.displayExpenseSummary()
    } else {
        println("Login failed. Incorrect password.")
    }
}