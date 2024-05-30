import java.util.*

open class Transaction(val id: Int, val amount: Double, val date: Date) {
    override fun toString(): String {
        return "Transaction ID: $id, Amount: $amount, Date: $date"
    }
}

class Income(id: Int, amount: Double, date: Date) : Transaction(id, amount, date) {
    override fun toString(): String {
        return "Income - " + super.toString()
    }
}

class Expense(id: Int, amount: Double, date: Date) : Transaction(id, amount, date) {
    override fun toString(): String {
        return "Expense - " + super.toString()
    }
}

fun main() {
    val income = Income(1, 100.0, Date())
    val expense = Expense(2, 50.0, Date())

    // Display details of income and expense transactions
    println("Income Transaction Details: $income")
    println("Expense Transaction Details: $expense")
}